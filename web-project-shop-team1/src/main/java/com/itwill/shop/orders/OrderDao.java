package com.itwill.shop.orders;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import com.itwill.shop.common.DataSource;


public class OrderDao {
	private DataSource datasource;
	//create,remove,update,select
	public OrderDao() throws Exception{
		datasource  = new DataSource();
	}	
	/*
	 * 주문생성 (주문 1개 + 주문아이템 1개 이상) - 트랜잭션 처리 필요.
	 */
	public int insert(Orders order) throws Exception {
		int rowCount = 0;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(OrderSQL.ORDERS_INSERT);
		pstmt1.setString(1, order.getO_desc());
		pstmt1.setInt(2, order.getO_price());
		pstmt1.setString(3, order.getUser_id());
		rowCount = pstmt1.executeUpdate();
		
		PreparedStatement pstmt2 =con.prepareStatement(OrderSQL.OREDRITEM_INSERT);
		for (OrderItem orderItem : order.getOrderItemList()) {
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
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.OREDRS_DELETE_BY_USER_ID);
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
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.OREDRS_DELETE_BY_O_NO);
		pstmt.setInt(1, o_no);
		rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	/*
	 * 주문전체보기
	 */
	
	/*
	 * 주문1개상세보기(난이도최상)
	 */
}