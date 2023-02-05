package com.itwill.shop.cart;

import com.itwill.shop.product.Product;
/*
 * 이름       널?       유형           
	-------- -------- ------------ 
	CART_NO  NOT NULL NUMBER(10)   
	CART_QTY          NUMBER(10)   
	M_ID              VARCHAR2(50) 
	P_NO              NUMBER(10)  
 */
public class Cart {
	private int cart_no;
	private int cart_qty;
	/************FK*************/
	private String m_id; 
	/************FK Product 포함*************/
	private Product product;
	
	public Cart() {
	}
	
	
	public Cart(int cart_no, int cart_qty, String m_id, Product product) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.m_id = m_id;
		this.product = product;
	}
	
	
	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", m_id=" + m_id + ", product=" + product + "]";
	}
	
	
	
	
	
}
