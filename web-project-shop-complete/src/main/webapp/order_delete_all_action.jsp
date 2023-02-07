<%@page import="com.itwill.shop.orders.OrderService_kangsan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
/*

         1.전체주문삭제
           	- 주문테이블 delete ON DELETE CASCADE
         */
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("order_list.jsp");
	return;
}
OrderService_kangsan orderService = new OrderService_kangsan();
orderService.delete(sUserId);
response.sendRedirect("order_list.jsp");
%>