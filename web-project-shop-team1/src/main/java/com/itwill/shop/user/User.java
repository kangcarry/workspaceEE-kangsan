package com.itwill.shop.user;

public class User {

	private String user_id;
	private String user_password;
	private String user_name;
	private String user_phone;
	private String user_email;
	private String user_address;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String user_password, String user_name, String user_phone, String user_email,
			String user_address) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", email=" + user_email + ", user_address=" + user_address + "]";
	}

	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.user_password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	
	

}







