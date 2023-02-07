package com.itwill.shop.cart;

public class CartSQL {
	/*
	 * Cart(cart_no,user_Id,p_no,cart_qty)
	 */
	
	public static final String CART_COUNT_BY_USERID_PRODUCT_NO = 
			"select count(*) as p_count from cart c join userinfo u on c.user_id = u.user_id where u.user_id=? and c.p_no=?";
	
	public static final String CART_INSERT = 
			"insert into cart(cart_no,user_id,cart_qty,p_no) values(cart_cart_no_SEQ.nextval,?,?,?)";
	
	public static final String CART_DELETE_BY_USERID = 
			"delete from cart where user_id=?";
	
	public static final String CART_DELETE_BY_CART_NO = 
			"delete from cart where cart_no=?";
	
	public static final String CART_UPDATE_BY_PRODUCT_NO_USERID = 
			"update cart set cart_qty=cart_qty+? where user_Id=? and p_no=?";
	
	public static final String CART_UPDATE_BY_CART_NO = 
			"update cart set cart_qty=? where cart_no=?";
	
	public static final String CART_SELECT_BY_USERID = 
			"select c.*,p.* from cart c join product p on c.p_no = p.p_no where user_id=?";

	public static final String CART_SELECT_BY_CARTNO = 
			"select * from cart c join product p on c.p_no = p.p_no where cart_no=?";
	

	
}
