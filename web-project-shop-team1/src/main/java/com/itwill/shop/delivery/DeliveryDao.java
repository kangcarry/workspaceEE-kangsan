package com.itwill.shop.delivery;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class DeliveryDao {
	private DataSource datasource;
	//create,remove,update,select
	public DeliveryDao() throws Exception{
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
	 * 주문창에서 배송정보 넣기
	 */
	
	public int insertDelivery (String d_address,String d_phone,String d_name,String user_id) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeliverySQL.DELIVERY_INSERT);
		pstmt.setString(1, d_address);
		pstmt.setString(2, d_phone);
		pstmt.setString(3, d_name);
		pstmt.setString(4, user_id);
		rowCount = pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	
	/*
	 * 주문창에서 배송정보 가져오기
	 */
	
	public Delivery selectDeliveryByuserId (String user_id) throws Exception {
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeliverySQL.DELIVERY_SELECT_BY_USER_ID);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		Delivery delivery = new Delivery();
		if(rs.next()){
		delivery.setD_address(rs.getString("d_address"));
		delivery.setD_phone(rs.getString("d_phone"));
		delivery.setD_name(rs.getString("d_name"));
		delivery.setUser_id(user_id);
		con.close();
		}
		return delivery;
	}
	
	/*
	 * 주문창에서 배송정보 바꾸기
	 */
	
	/*
	public int updateDelivery (String d_address,String d_phone,String d_name,String user_id) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeliverySQL.DELIVERY_UPDATE);
		pstmt.setString(1, d_address);
		pstmt.setString(2, d_phone);
		pstmt.setString(3, d_name);
		pstmt.setString(4, user_id);
		rowCount = pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	*/
	
	/*
	 * 주문창에서 배송정보 지우기
	 */
	
	public int deleteDelivery (String user_id) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeliverySQL.DELIVERY_DELETE_BY_USER_ID);
		pstmt.setString(1, user_id);
		rowCount = pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	
	
}