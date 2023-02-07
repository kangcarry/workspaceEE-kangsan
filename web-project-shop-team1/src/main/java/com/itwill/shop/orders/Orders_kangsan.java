package com.itwill.shop.orders;

import java.util.Date;
import java.util.List;

/*
이름        널?       유형             
--------- -------- -------------- 
O_NO      NOT NULL NUMBER(10)     
O_NAME             VARCHAR2(50)   
O_DESC             VARCHAR2(1000) 
O_DATE             DATE           
O_PRICE            NUMBER(10)     
O_ADDRESS          VARCHAR2(500)  
O_LOC              VARCHAR2(500)  
O_PAYMENT          VARCHAR2(50)   
M_ID               VARCHAR2(50)  
 */
/**
 * @author USER
 *
 */
public class Orders_kangsan {
	private int o_no;
	private String o_desc;
	private Date o_date;
	private int o_price;
	/********* FK **********/
	private String user_id;
	/****** List<OrderItem> 포함 ******/
	private List<OrderItem_kangsan> orderItemList;

	public Orders_kangsan() {

	}
	

	public Orders_kangsan(int o_no, String o_desc, Date o_date, int o_price, String user_id,List<OrderItem_kangsan> orderItemList) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_date = o_date;
		this.o_price = o_price;
		this.user_id = user_id;
		this.orderItemList = orderItemList;
	}
	
	
	public Orders_kangsan(int o_no, String o_desc, Date o_date, int o_price, String user_id) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_date = o_date;
		this.o_price = o_price;
		this.user_id = user_id;
	}
	
	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_desc() {
		return o_desc;
	}

	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<OrderItem_kangsan> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem_kangsan> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Orders [o_no=" + o_no + ", o_desc=" + o_desc + ", o_date=" + o_date + ", o_price=" + o_price
				+ ", user_id=" + user_id + ", orderItemList=" + orderItemList + "]";
	}

	
	
}
