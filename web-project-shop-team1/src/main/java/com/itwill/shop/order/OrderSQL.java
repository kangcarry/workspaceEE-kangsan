package com.itwill.shop.order;

public class OrderSQL {
	public static final String ORDERS_INSERT= 
										"insert into orders(o_no, o_desc, o_date, o_price, user_id) values(orders_o_no_SEQ.nextval, ?, sysdate, ?, ?)";
	public static final String ORDER_ITEM_INSERT = 
										"insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, ?, orders_o_no.SEQ_currval, ?)";
	public static final String ORDERS_DELETE_BY_USER_ID= 
										"delete from orders where user_id = ?";
	public static final String ORDERS_DELETE_BY_O_NO= 
										"delete from orders where o_no = ?";
	public static final String ORDERS_SELECTE_BY_USER_ID= 
										"select * from orders where user_id = ?";
	public static final String ORDERS_SELECTE_WITH_ORDER_ITEM_BY_USER_ID= 
										"select * from orders o join order_item oi on o.o_no = oi.o_no join product p on oi.p_no = p.p_no where o.user_id = ?";
	public static final String ORDERS_SELECTE_WITH_ORDER_ITEM_BY_O_NO= 
										"select * from orders o join order_item oi on o.o_no = oi.o_no join product p on oi.p_no = p.p_no where o.o_no = ?";
}