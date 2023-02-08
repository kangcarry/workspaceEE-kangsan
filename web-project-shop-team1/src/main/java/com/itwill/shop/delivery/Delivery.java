package com.itwill.shop.delivery;

public class Delivery {

	private String d_address;
	private String d_phone;
	private String d_name;
	//fk
	private String user_id;

	public Delivery() {
	}

	
	public Delivery(String d_address, String d_phone, String d_name, String user_id) {
		super();
		this.d_address = d_address;
		this.d_phone = d_phone;
		this.d_name = d_name;
		this.user_id = user_id;
	}


	public String toString() {
		return "delivery [d_address=" + d_address + ", d_phone=" + d_phone + ", d_name=" + d_name + ", user_id="
				+ user_id + "]";
	}

	public String getD_address() {
		return d_address;
	}

	public void setD_address(String d_address) {
		this.d_address = d_address;
	}

	public String getD_phone() {
		return d_phone;
	}

	public void setD_phone(String d_phone) {
		this.d_phone = d_phone;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
