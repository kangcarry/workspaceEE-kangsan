	<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%

	/*
	* 0.요청객체encoding설정
	* 1.파라메타받기
	* 2.AddressService객체생성
	* 3.AddressService.deleteByNo()메쏘드실행
	* 4.클라이언트로 redirection 응답--> address_list.jsp 로 redirection
	*/
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	AddressService addressService = new AddressService();
	addressService.delete(Integer.parseInt(no));
	response.sendRedirect("address_list.jsp");
	
	%>