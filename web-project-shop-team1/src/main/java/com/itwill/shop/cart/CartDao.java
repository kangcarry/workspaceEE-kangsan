package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.product.Product;

public class CartDao {

		private DataSource dataSource;
		public CartDao() throws Exception{
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

	/*
	 * cart에 제품이 존재하는지 확인
	 * 존재하지 않는다면(0) => insert / 존재한다면(1) => update 
	 */
	public int countByProductNo(String sUserId, int p_no) throws Exception {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_COUNT_BY_USERID_PRODUCT_NO);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;
	}
		
		
	/*
	 * insert
	 * cart에 존재하지 않는 제품 추가
	 */
	
	//cart_no,user_Id,p_no,cart_qty
	public int insertCart(Cart cart) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setString(1, cart.getUser_Id());
			pstmt.setInt(2, cart.getCart_qty());
			pstmt.setInt(3, cart.getProduct().getP_no());
			insertRowCount = pstmt.executeUpdate();
			
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return insertRowCount;
}
	
	
	/*
	 * delete
	 */
	//카트에 담긴 상품 전체 삭제
	public int deleteByUserId(String sUserId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	
	
	//카트에 담긴 상품 중 한가지 항목 삭제
	public int deleteByCartNo(int cart_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
			pstmt.setInt(1, cart_no);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
		
	
	/*
	 * update
	 */
	//상품 페이지에서 장바구니에 추가 (수량 변경)
	public int updateByProductNo(Cart cart) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_USERID);
			pstmt.setInt(1, cart.getCart_qty());
			pstmt.setString(2, cart.getUser_Id());
			pstmt.setInt(3, cart.getProduct().getP_no());
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return rowCount;
	}	
	

	//카트에서 수량 변경
	public int updateByCartNo(Cart cart) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
			pstmt.setInt(1, cart.getCart_qty());
			pstmt.setInt(2, cart.getCart_no());
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return rowCount;
	}
	
	
	/*
	 * List
	 */
	public List<Cart> findByUserId(String user_Id) throws Exception{
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
		pstmt.setString(1, user_Id);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			cartList.add(new Cart( rs.getInt("cart_no"),
								   rs.getString("user_Id"),
								   rs.getInt("cart_qty"),
							       new Product(rs.getInt("p_no"),
							    		       rs.getString("p_name"),
							    		       rs.getInt("p_price"),
							    		       rs.getString("p_image"),
							    		       rs.getString("p_desc"), 
							    		       rs.getInt("p_click_count"),
							    		       rs.getInt("category_no"))
						));
		}
		return cartList;
	}
		
		
}
