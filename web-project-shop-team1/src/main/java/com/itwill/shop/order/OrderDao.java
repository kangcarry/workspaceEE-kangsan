package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.product.Product;

public class OrderDao {
	private DataSource dataSource;
	
	public OrderDao() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	
	
	/*********** insert(새로운 주문 생성) **********/
	public int insert(Order order) throws Exception {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDERS_INSERT);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_price());
			pstmt1.setString(3, order.getUser_id());
			
			rowCount = pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrderSQL.ORDER_ITEM_INSERT);
			for (OrderItem  orderItem : order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			if(pstmt1 != null) {
				pstmt1.close();
			}
			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*****************************************************************************************************/
	
	/*********** delete(특정 주문 번호로 삭제) **********/
	public int deleteByOrderNo(int o_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDERS_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*****************************************************************************************************/
	
	/*********** delete(특정 회원의 전체 주문 생성) **********/
	public int deleteByUserId(String user_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDERS_DELETE_BY_USER_ID);
			pstmt.setString(1, user_id);
			rowCount = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*****************************************************************************************************/
	
	/**************************** select(특정 회원의 주문 리스트 조회) ********************************/
	public List<Order> findByUserId(String user_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDERS_SELECTE_BY_USER_ID);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(
						new Order(
								rs.getInt("o_no"), 
								rs.getString("user_id"), 
								rs.getDate("o_date"), 
								rs.getInt("o_price"), 
								rs.getString("user_id")
								));
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return orderList;
	}
	/*****************************************************************************************************/
	
	/*********** select(특정 회원의 주문상품을 포함한 주문 정보 조회) ******************/
	public List<Order> findWithOrderItemByUserId(String user_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			con = dataSource.getConnection();
			pstmt1 = con.prepareStatement(OrderSQL.ORDERS_SELECTE_BY_USER_ID);
			pstmt1.setString(1, user_id);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				orderList.add(new Order(rs1.getInt("o_no"), rs1.getString("o_desc"), rs1.getDate("o_date"), rs1.getInt("o_price"), rs1.getString("user_id")));
			}
			
			pstmt2 = con.prepareStatement(OrderSQL.ORDERS_SELECTE_WITH_ORDER_ITEM_BY_O_NO);
			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				pstmt2.setInt(1, order.getO_no());
				rs2 = pstmt2.executeQuery();
				
				Order orderWithOrderItem = null;
				if(rs2.next()) {
					orderWithOrderItem = new Order(rs2.getInt("o_no"), 
													rs2.getString("o_desc"), 
													rs2.getDate("o_date"), 
													rs2.getInt("o_price"), 
													rs2.getString("user_id"));
					do {
						orderWithOrderItem.getOrderItemList().add(new OrderItem(
																	rs2.getInt("oi_no"), rs2.getInt("oi_qty"), rs2.getInt("o_no"), 
																			new Product(
																					rs2.getInt("p_no"), 
																					rs2.getString("p_name"), 
																					rs2.getInt("p_price"), 
																					rs2.getString("p_image"), 
																					rs2.getString("p_desc"),
																					rs2.getInt("p_click_count"), 
																					rs2.getInt("category_no"))));
						
					} while (rs2.next());
				}
				orderList.set(i, orderWithOrderItem);
			}
		}
		finally {
			if(rs1 != null || rs2 != null) {
				rs1.close();
				rs2.close();
			}
			if(pstmt1 != null || pstmt2 != null) {
				pstmt1.close();
				pstmt2.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return orderList;

	}
	
	/*********** select(특정 주문번호의 주문상품을 포함한 주문 상세정보 조회) **********/
	public Order findWithOrderItemByOrderNo(int o_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDERS_SELECTE_WITH_ORDER_ITEM_BY_O_NO);
			pstmt.setInt(1, o_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new Order(
							rs.getInt("o_no"), 
							rs.getString("o_desc"), 
							rs.getDate("o_date"), 
							rs.getInt("o_price"), 
							rs.getString("user_id"));
			}
			do {
				order.getOrderItemList().add(new OrderItem(rs.getInt("oi_no"), rs.getInt("oi_qty"), rs.getInt("o_no"), 
						new Product(
								rs.getInt("p_no"), 
								rs.getString("p_name"), 
								rs.getInt("p_price"), 
								rs.getString("p_image"), 
								rs.getString("p_desc"),
								rs.getInt("p_click_count"), 
								rs.getInt("category_no"))));
				
			} while(rs.next());
		} finally {
			if(rs != null) {
				rs.close();
				
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}		
		return order;
	}
}
