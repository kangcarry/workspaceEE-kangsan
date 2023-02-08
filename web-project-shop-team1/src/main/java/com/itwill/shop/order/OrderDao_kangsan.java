package com.itwill.shop.order;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.delivery.DeliverySQL;
import com.itwill.shop.product.Product;


public class OrderDao_kangsan {
	private DataSource datasource;
	//create,remove,update,select
	public OrderDao_kangsan() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		datasource = basicDataSource;
	}	
	
	/*
	 * 주문생성 (주문 1개 + 주문아이템 1개 이상) - 트랜잭션 처리 필요.
	 */
	public int insert(Orders_kangsan order) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(OrderSQL_kangsan.ORDERS_INSERT);
		pstmt1.setString(1, order.getO_desc());
		pstmt1.setInt(2, order.getO_price());
		pstmt1.setString(3, order.getUser_id());
		rowCount = pstmt1.executeUpdate();
		
		PreparedStatement pstmt2 =con.prepareStatement(OrderSQL_kangsan.OREDRITEM_INSERT);
		for (OrderItem_kangsan orderItem : order.getOrderItemList()) {
			pstmt2.clearParameters();
			pstmt2.setInt(1, orderItem.getOi_qty());
			pstmt2.setInt(2, orderItem.getProduct().getP_no());
			pstmt2.executeUpdate();
		}
		pstmt1.close();
		pstmt2.close();
		return rowCount;
	}
	/*
	 * 주문전체삭제
	 */
	
	public int deleteByUserId(String user_Id) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL_kangsan.OREDRS_DELETE_BY_USER_ID);
		pstmt.setString(1, user_Id);
		rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	/*
	 * 주문 1개삭제
	 */

	public int deleteByO_no(int o_no) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL_kangsan.OREDRS_DELETE_BY_O_NO);
		pstmt.setInt(1, o_no);
		rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	/*
	 * 주문전체보기
	 */
	public List<Orders_kangsan> findOrdersByUserId(String user_Id) throws Exception{
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL_kangsan.OREDRS_SELECT_BY_USER_ID);
		
		pstmt.setString(1, user_Id);
		List<Orders_kangsan> ordersList = new <Orders_kangsan> ArrayList();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ordersList.add(new Orders_kangsan(rs.getInt("o_no"),rs.getString("o_desc"),rs.getDate("o_date"),rs.getInt("o_price"),rs.getString("user_id")));
		}

		pstmt.close();
		con.close();
		return ordersList;
	}
	
	/*
	 * 주문+주문아이템전체(특정사용자)
	 */
	public List<Orders_kangsan> findOrderWithOrdersItemByUserId(String user_id) throws Exception{
		List<Orders_kangsan> orderList = this.findOrdersByUserId(user_id);
		for(int i=0; i<orderList.size(); i++) {
		Orders_kangsan orders = orderList.get(i);
		Orders_kangsan orderWithOrdersItem = this.findByOrdersNo(orders.getO_no());
		orderList.set(i, orderWithOrdersItem);
		}
		return orderList;
	}
	
	
	/*
	 * 주문1개상세보기(주문상세리스트,난이도 최상)
	 */
	public Orders_kangsan findByOrdersNo(int o_no) throws Exception {
		Orders_kangsan orders = null;
		List<OrderItem_kangsan> orderList=new ArrayList<OrderItem_kangsan>();
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL_kangsan.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
		pstmt.setInt(1, o_no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			orders = new Orders_kangsan(rs.getInt("o_no"),
								rs.getString("o_desc"),
								rs.getDate("o_date"),
								rs.getInt("o_price"),
								rs.getString("user_id"),
								orderList);
			do {
			orders.getOrderItemList().
								add(new OrderItem_kangsan(rs.getInt("oi_no"),
												  rs.getInt("oi_qty"),
												  rs.getInt("o_no"),
												  new Product(rs.getInt("p_no"),
															  rs.getString("p_name"),
															  rs.getInt("p_price"),
															  rs.getString("p_image"),
															  rs.getString("p_desc"),
															  rs.getInt("p_click_count"),
															  rs.getInt("category_no"))
												 ));
			}while(rs.next());
		} 
		pstmt.close();
		con.close();
		return orders;
	}
	
	
}