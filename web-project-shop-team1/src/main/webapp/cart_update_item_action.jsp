<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>    
<%
    if(request.getMethod().equalsIgnoreCase("GET")){
    		response.sendRedirect("product_list.jsp");
    		return;
    	}

    	String cart_qty = request.getParameter("cart_qty");
    	String cart_no = request.getParameter("cart_no");
    	
    	CartService cartService = new CartService();
    	Cart cart = new Cart(Integer.parseInt(cart_no),null,Integer.parseInt(cart_qty),null);
    	if(cart_qty.equals("0")){
    		cartService.deleteCartItemByCartNo(Integer.parseInt(cart_no));
    	}else{
    		cartService.updateCart(cart);
    	}
    	response.sendRedirect("cart_view.jsp");
    %>