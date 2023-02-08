<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%
	CartService cartService = new CartService();
	List<Cart> cartList = cartService.viewCartByUserId(sUserId);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">

<style type="text/css" media="screen"></style>

<script src="js/cart.js"></script>
</head>

<body onload="cart_item_select_count();" bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0	marginwidth=0 marginheight=0>
	<form name="cart_view_form" style="margin:0">
		<input type="hidden" name="buyType">
	</form>
	<!-- container start-->
	<div id="container">
		<div id="header">
			<jsp:include page="include_common_top.jsp" />
		</div>
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td height="22">&nbsp;&nbsp;<b>쇼핑몰 - 장바구니 보기</b></td>
								</tr>
							</table> <!--form name="f" method="post"--> 

							<div id='f'>
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<tr>
										<!-- 체크박스 전체 선택 -->
										<td width=60 height=25 align="center" bgcolor="E6ECDE" class=t1>
											<input type="checkbox" id="all_select_checkbox" checked="checked" onchange="cart_item_all_select(event);cart_item_select_count();"></td>
										<td width=40 height=25 align="center" bgcolor="E6ECDE" class=t1>
											<font>이미지</font></td>
										<td width=210 height=25 align="center" bgcolor="E6ECDE"	class=t1>
											<font>상품명</font></td>
										<td width=112 height=25 align="center" bgcolor="E6ECDE"	class=t1>
											<font>수량</font></td>
										<td width=146 height=25 align="center" bgcolor="E6ECDE"	class=t1>
											<font>가격</font></td>
										<td width=50 height=25 align="center" bgcolor="E6ECDE"	class=t1><font>삭제</font></td>
									</tr>
									<!-- cart item start -->
									<%
									int tot_price = 0;
									for (Cart cart : cartList) {
										tot_price += cart.getProduct().getP_price() * cart.getCart_qty();
									%>
									<tr>
										<td width=60 height=26 align=center bgcolor="ffffff" class=t1>
										 <input type="checkbox" name="cart_item_no_check" onchange="cart_item_all_select_checkbox_deselect();cart_item_select_count();" value="<%=cart.getCart_no()%>" checked="checked">
										</td>
										<td width=40 height=26 align=center bgcolor="ffffff" class=t1>
											<img src='image/<%=cart.getProduct().getP_image()%>' width="34" height="28" />
										</td>
										<td width=210 height=26 align=center bgcolor="ffffff" class=t1>
											<a href='product_detail.jsp?p_no=<%=cart.getProduct().getP_no()%>'><%=cart.getProduct().getP_name()%></a>
										</td>
<!-- qty form start -->
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1>
											<form action="cart_update_item_action.jsp" method="post"	id="cart_update_form_<%=cart.getCart_no()%>">
												<input type="hidden" name="cart_no"	value="<%=cart.getCart_no()%>"> 
												<input type="button" value="-"	onclick="modify_qty('-','cart_update_form_<%=cart.getCart_no()%>');"/>
												<input type="text" readonly="readonly" size="2"	style="text-algin: center; width: 15%" name="cart_qty"	value="<%=cart.getCart_qty()%>"> 
												<input type="button" value="+"	onclick="modify_qty('+','cart_update_form_<%=cart.getCart_no()%>');"/>
												<input type="hidden" name="cart_product_unit_price" value="<%=cart.getProduct().getP_price()%>"/>	
												<input type='submit' value='변경'>											
											</form>
										</td>
<!-- qty form end -->
										<td width=146 height=26 align=center bgcolor="ffffff" class=t1><%=new DecimalFormat("#,##0").format(cart.getProduct().getP_price() * cart.getCart_qty())%></td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1>

											<form id="cart_delete_item_form_<%=cart.getCart_no()%>">
												<input type="hidden" name="cart_no"	value="<%=cart.getCart_no()%>"> 
												<a href="cart_delete_item_action('cart_delete_item_form_<%=cart.getCart_no()%>');">
													<svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 28 28" class="icon--close">
													<g fill="none" fill-rule="evenodd"> 
													<path d="M0 0H28V28H0z"></path> 
													<g fill="#9B9BA0" transform="translate(6 6)" class="icon--close__group">
													<rect width="2" height="18" x="7" y="-1" rx="1"	transform="rotate(-135 8 8)"></rect> 
													<rect width="2"	height="18" x="7" y="-1" rx="1"	transform="rotate(-45 8 8)"></rect> 
													</g> </g> </svg>
												</a>
											</form>

										</td>
									</tr>
									<%}%>
									<!-- cart item end -->

									<tr>
										<td width=640 colspan=6 height=26 class=t1 bgcolor="ffffff">
											<p align=right>
												<br /> 
												<font color='red'>총주문금액 : <span id="tot_order_price"><%=new DecimalFormat("#,##0").format(tot_price)%></span> 원</font>
											</p>
										</td>
									</tr>
								</table>

							</div> 
							<!-- </form> --> <br />

							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp; <a href="product_list.jsp" class=m1>계속 쇼핑하기</a>&nbsp;&nbsp; 
										<% if (cartList.size() >= 1) {%> 
										<a href="cart_view_form_select_submit();" class=m1>
										 	총 <span style="font-weight: bold;" id="cart_item_select_count"></span>개 주문</a>&nbsp;&nbsp;
											<a href="cart_delete();" class=m1>장바구니 비우기</a>&nbsp;&nbsp;
											<%}%>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<div id="footer">
			<jsp:include page="include_common_bottom.jsp" />
		</div>
	</div>
	<!--container end-->
</body>
</html>