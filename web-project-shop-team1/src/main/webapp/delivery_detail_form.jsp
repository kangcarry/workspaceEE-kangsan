<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.delivery.Delivery"%>
<%@page import="com.itwill.shop.delivery.DeliveryService"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%

	
	DeliveryService deliveryService = new DeliveryService();
	List <Delivery> deliveryList=  deliveryService.selectDelivery(sUserId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div style="width:1000px; margin:0 auto; padding: 0px;">
<table align=center width=80% border="0" cellpadding="0"cellspacing="1" bgcolor="BBBBBB">
			<tr>
				<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>받으시는 분</td>
				<td width=112 height=25 align=center bgcolor="E6ECDE" class=t1>연락처</td>
				<td width=166 height=25 align=center bgcolor="E6ECDE" class=t1>이메일</td>
				<td width=50 height=25 align=center bgcolor="E6ECDE" class=t1>배송지</td>
			</tr>
			<%for(Delivery delivery:deliveryList) { %>
			<tr>
				<td width=150 height=26 align=center bgcolor="ffffff" class=t1><%=delivery.getUser_id()%></td>
				<td width=152 height=26 align=center bgcolor="ffffff" class=t1><%=delivery.getD_name()%></td>
				<td width=126 height=26 align=center bgcolor="ffffff" class=t1><%=delivery.getD_phone()%></td>
				<td width=170 height=26 align=center bgcolor="ffffff" class=t1><%=delivery.getD_address()%></td>
			</tr>	
			<%} %>					
</table>
</div>
</body>
</html>
