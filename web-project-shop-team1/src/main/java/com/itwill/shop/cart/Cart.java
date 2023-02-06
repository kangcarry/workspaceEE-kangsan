package com.itwill.shop.cart;

import com.itwill.shop.product.Product;

public class Cart {
	
	private int cart_no;
	private String user_Id;
	private int cart_qty;
	private Product product;
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}


	public Cart(int cart_no, String user_Id, int cart_qty, Product product) {
		super();
		this.cart_no = cart_no;
		this.user_Id = user_Id;
		this.cart_qty = cart_qty;
		this.product = product;
	}


	public int getCart_no() {
		return cart_no;
	}


	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}


	public String getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}


	public int getCart_qty() {
		return cart_qty;
	}


	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", user_Id=" + user_Id + ", cart_qty=" + cart_qty + ", product=" + product
				+ "]\n";
	}
	
	


	
}