	<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%
	/*
	 * 0.요청객체encoding설정
	 * 1.파라메타받기
	 * 2.AddressService객체생성
	 * 3.AddressService.insert()메쏘드실행
	 * 4.address_main.jsp 로 redirection
	 */
	 
	 request.setCharacterEncoding("UTF-8");
	 String name = request.getParameter("name");
	 String phone = request.getParameter("phone");
	 String address = request.getParameter("address");
	 AddressService addressService = new AddressService();
	 addressService.insert(new Address(0,name,phone,address));
	 response.sendRedirect("address_main.jsp");
	  
	 
	%>