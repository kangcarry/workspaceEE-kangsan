<%@page import="com.itwill.shop.user.UserService"%>
<%@page import="com.itwill.shop.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>     
<%
	if(request.getMethod().equals("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
		request.setCharacterEncoding("UTF-8");
		String user_password=request.getParameter("user_password");
		String user_name=request.getParameter("user_name");
		String user_phone=request.getParameter("user_phone");
		String user_email=request.getParameter("user_email");
		String user_address=request.getParameter("user_address");
		User user=new User(sUserId,user_password,user_name,user_phone,user_email,user_address);
		UserService userService=new UserService();
		int updateRowCount=userService.update(user);
		
		response.sendRedirect("user_view.jsp");
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
	
%>






