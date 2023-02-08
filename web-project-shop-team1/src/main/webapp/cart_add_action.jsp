<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>       
<%
       if(request.getMethod().equalsIgnoreCase("GET")){
       		response.sendRedirect("product_list.jsp");
       		return;
       	}

		String cart_qty = request.getParameter("cart_qty");
       	String p_no = request.getParameter("p_no");
       	
       	CartService cartService = new CartService();
       	cartService.addCart(new Cart(0,sUserId,Integer.parseInt(cart_qty),
       			new Product(Integer.parseInt(p_no),null,0,null,null,0,0)));
  
       	response.sendRedirect("cart_view.jsp");
    
       %>