package com.itwill.shop.user;

public class UserSQL {
	public final static String USER_INSERT=
	"insert into userinfo(user_id,user_password,user_name,user_phone,user_email,user_address) values(?,?,?,?,?,?)";
	public final static String USER_UPDATE=
	"update userinfo set user_password=?,user_name=?,user_phone=?,user_email=?,user_address=? where user_id=?";
	public final static String USER_REMOVE=
	"delete userinfo where user_id=?";
	public final static String USER_SELECT_BY_ID=
	"select user_id,user_password,user_name,user_phone,user_email,user_address from userinfo where user_id=?";
	public final static String USER_SELECT_ALL=
	"select user_id,user_password,user_name,user_phone,user_email,user_address from userinfo";
	public final static String USERID_SELECT_ALL=
	"select user_id from userinfo";
	public final static String USER_SELECT_BY_ID_COUNT=
			"select count(*) cnt from userinfo where user_id=?";
}
