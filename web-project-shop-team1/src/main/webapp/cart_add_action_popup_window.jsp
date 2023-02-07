<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("product_list.jsp");
		return;
	}
	
	String cart_qtyStr = request.getParameter("cart_qty");
	String p_noStr = request.getParameter("p_no");
	
	CartService cartService = new CartService();
	Cart cart = new Cart(0,sUserId,Integer.parseInt(cart_qtyStr),
				new Product(Integer.parseInt(p_noStr),null,0,null,null,0,0));
			
	cartService.addCart(cart);
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
<div style="width:200px; margin:0 auto; padding: 0px;">
	<img src="http://pics.gmkt.kr/pc/ko/item/vip/img_cartplus_n.png" width="25px" height="25px"
		alt="장바구니이미지">
	<strong>장바구니에 상품이 담겼습니다.</strong>
	<div  style="margin-top: 5px;margin-left: auto;margin-right: auto;padding: 5px" >
		<div  style="margin: 0 auto;padding: 0px 20px">
			<button onclick="window.close();opener.location.reload();" style="font-size: 6pt">
				계속 쇼핑
			</button>

			<button onclick="window.close();opener.location.href='cart_view.jsp';" style="font-size: 6pt">
				장바구니
			</button>
		</div>
	</div>
</div>
</body>
</html>
