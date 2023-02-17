package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller {
	private UserService userService;
	public UserRemoveActionController() throws Exception {
		userService = new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		/**************** login_check *******************/
		
		/*********************************************/
		/*
		0.login 여부체크
		1.GET방식이면 redirect:user_main.do  forwardPath반환
		2.요청객체인코딩설정
		3.세션에있는 sUserId를 사용해서 UserService.remove(sUserId) 메쏘드호출
		4.성공: redirect:user_main.do  forwardPath반환
		  실패: forward:/WEB-INF/views/user_error.jsp  forwardPath반환
		*/
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:user_main.do";
			} else {
				String userId = request.getParameter("userId");
				userService.remove(userId);
				forwardPath = "redirect:user_main.do";
				}
			}catch (Exception e) {
			forwardPath = "redirect:user_error.do";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
