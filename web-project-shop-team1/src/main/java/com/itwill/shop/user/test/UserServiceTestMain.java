package com.itwill.shop.user.test;

import java.util.List;

import com.itwill.shop.user.UserService;

public class UserServiceTestMain {
	public static void main(String[] args) throws Exception {
		UserService userService = new UserService();
		List userIdList = userService.findUserIdList();
		System.out.println(userIdList);
	}
}
