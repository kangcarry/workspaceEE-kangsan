<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>       
<%
       if(request.getMethod().equalsIgnoreCase("GET")){
       		response.sendRedirect("product_list.jsp");
       		return;
       	}

		String cart_qtyStr=request.getParameter("cart_qty");
       	String p_noStr=request.getParameter("p_no");
       	CartService cartService=new CartService();
       	Cart cart = new Cart();
       	cartService.addCart(cart);
       	
       	response.sendRedirect("cart_view.jsp");
       %>