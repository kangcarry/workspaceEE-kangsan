package com.itwill.shop.product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class ProductDao {
	private DataSource dataSource;
	public ProductDao() throws Exception {
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
	 * 카테고리별 상품 검색
	 */
	public List<Product> findByCategory(int category_no) throws Exception {
		List<Product> productList=new ArrayList<Product>();
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_CATEGORY);
		pstmt.setInt(1, category_no);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Product product = new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"), 
					  			rs.getString("p_image"), rs.getString("p_desc"), 
					  			rs.getInt("p_click_count"), rs.getInt("category_no"));
			productList.add(product);
		}
		rs.close();
		pstmt.close();
		con.close();
		return productList;
	}
	/*
	 * 상품추가
	 */
	public int insert(Product product) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);
		pstmt.setInt(1, product.getP_no());
		pstmt.setString(2, product.getP_name());
		pstmt.setInt(3, product.getP_price());
		pstmt.setString(4, product.getP_image());
		pstmt.setString(5, product.getP_desc());
		pstmt.setInt(6, product.getP_click_count());
		pstmt.setInt(7, product.getCategory_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	/*
	 * 상품 update
	 */
	public int update(Product product) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE);
		pstmt.setString(1, product.getP_name());
		pstmt.setInt(2, product.getP_price());
		pstmt.setString(3, product.getP_image());
		pstmt.setString(4, product.getP_desc());
		pstmt.setInt(5, product.getP_click_count());
		pstmt.setInt(6, product.getCategory_no());
		pstmt.setInt(7,product.getP_no());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	/*
	 * 상품이름으로삭제
	 */
	public int delete(String p_name )throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE);
		pstmt.setString(1, p_name);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	/*
	 * 상품번호검색
	 */
	public Product selectByNo(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NO);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product = new Product(rs.getInt("p_no"),
								  rs.getString("p_name"),
								  rs.getInt("P_price"),
								  rs.getString("p_image"),
								  rs.getString("p_desc"),
								  rs.getInt("p_click_count"),
								  rs.getInt("category_no"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return product;
	}
	/*
	 * 상품전체검색
	 */
	public List<Product> selectAll() throws Exception{
		List<Product> productList=new ArrayList<Product>();
		
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Product product = new Product(
					  rs.getInt("p_no"),
					  rs.getString("p_name"),
					  rs.getInt("p_price"),
					  rs.getString("p_image"),
					  rs.getString("p_desc"),
					  rs.getInt("p_click_count"),
					  rs.getInt("category_no"));
			productList.add(product);
		}
		rs.close();
		pstmt.close();
		con.close();
		return productList;
	}
}
