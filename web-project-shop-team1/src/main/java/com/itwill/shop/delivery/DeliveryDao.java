package com.itwill.shop.delivery;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		con = datasource.getConnection();
		pstmt = con.prepareStatement(DeliverySQL.DELIVERY_INSERT);
		pstmt.setString(1, d_address);
		pstmt.setString(2, d_phone);
		pstmt.setString(3, d_name);
		pstmt.setString(4, user_id);
		rowCount = pstmt.executeUpdate();
		}catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(con != null) {
			con.close();
			}
		}
		return rowCount;
	}
	
	/*
	 * 주문창에서 배송정보 가져오기
	 */
	
	public List<Delivery> selectDeliveryByuserId (String user_id) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		List<Delivery> deliverieList = new ArrayList<Delivery>();
		try {
		con = datasource.getConnection();
		pstmt = con.prepareStatement(DeliverySQL.DELIVERY_SELECT_BY_USER_ID);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
	
		while(rs.next()){
			deliverieList.add(new Delivery(
					rs.getString("d_address"),
					rs.getString("d_phone"),
					rs.getString("d_name"),
					rs.getString(user_id)));
		}}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(con != null) {
			con.close();
			}
		}
		return deliverieList;
	}
	
	public Delivery selectDeliveryByAddress (String d_address) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		Delivery delivery = new Delivery();
		try {
		con = datasource.getConnection();
		pstmt = con.prepareStatement(DeliverySQL.DELIVERY_SELECT_BY_D_ADDRESS);
		pstmt.setString(1, d_address);
		ResultSet rs = pstmt.executeQuery();
	
		if(rs.next()){
			delivery= new Delivery(
					rs.getString("d_address"),
					rs.getString("d_phone"),
					rs.getString("d_name"),
					rs.getString("user_id"));
		}}catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(con != null) {
			con.close();
			}
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
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		con = datasource.getConnection();
		pstmt = con.prepareStatement(DeliverySQL.DELIVERY_DELETE_BY_USER_ID);
		pstmt.setString(1, user_id);
		rowCount = pstmt.executeUpdate();
		}catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(con != null) {
			con.close();
			}
		}
		return rowCount;
	}
	
	
}