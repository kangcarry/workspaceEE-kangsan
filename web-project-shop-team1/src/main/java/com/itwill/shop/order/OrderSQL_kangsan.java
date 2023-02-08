package com.itwill.shop.order;

public class OrderSQL_kangsan {
	public final static String ORDERS_INSERT =
			"insert into orders(o_no,o_desc,o_date,o_price,user_id) values(orders_o_no_SEQ.nextval,?, sysdate, ?, ?)";
	public final static String OREDRITEM_INSERT = 
			"insert into order_item(oi_no,oi_qty,p_no,o_no) values(order_item_oi_no_SEQ.nextval, ?, ?, orders_o_no_SEQ.currval)";
	public final static String OREDRS_DELETE_BY_USER_ID = 
			"delete orders where user_id = ?";
	public final static String OREDRS_DELETE_BY_O_NO = 
			"delete orders where o_no = ?";
	public final static String OREDRS_SELECT_BY_USER_ID = 
			"select * from orders where user_id = ?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_O_NO =
			"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.o_no = ?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_USERID =
			"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where  o.userid = ? ";
	
}