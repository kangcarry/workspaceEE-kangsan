<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int cart_item_count=0;
	String sUserId=(String)session.getAttribute("sUserId");
	if(sUserId!=null){
		CartService cartService=new CartService();
	  	cart_item_count = cartService.viewCartByUserId(sUserId).size();

	}
%>		
<div id="menu">
	<ul>
		<li id="logo"><a href="shop_main.jsp"></a></li>
		<%if(sUserId==null){  %>
			<li id="cart" title="장바구니"><span class="w3-badge-no-login w3-green-no-login w3-margin-right">0 </span><a href="user_login_form.jsp" title="장바구니"></a></li>
			<li id="join" title="회원가입" ><a href="user_write_form.jsp" ></a></li>
			<li id="login" title="로그인" ><a href="user_login_form.jsp" ></a></li>
			
		<%}else{ %>
			<li id="mypage" title="나의페이지" ><a href="user_view.jsp"></a></li>
			<li id="cart" title="장바구니"><span class="w3-badge w3-green w3-margin-right"><%=cart_item_count%></span><a href="cart_view.jsp"></a></li>
			
		<%} %>
	</ul>
</div>