<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.order.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%
OrderService orderService = new OrderService();
List<Order> orderList = orderService.findByUserId(sUserId);
List<OrderItem> orderItemList = new ArrayList<OrderItem>();

String o_noStr = request.getParameter("o_no");
Order thisOrder = orderService.findWithOrderItemByOrderNo(Integer.parseInt(o_noStr));

// 화폐단위 구분을 위해 numberFormat 설정
NumberFormat numberFormat = NumberFormat.getInstance();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<style type="text/css" media="screen">
/*
form > table tr td{
	border: 0.1px solid black;
}
*/
</style>
<script type="text/javascript">
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- wrapper start -->
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b><%= sUserId %>님의 주문 상세 조회</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post" action="order_delete_action.jsp">
								<input type="hidden" name="o_no" value="18">
								<table align="center" width="80%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
									<caption style="text-align: left;">주문상세정보</caption>
									<tr>
										<td width=290 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문번호</font></td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문일</font></td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문자</font></td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>비 고</font></td>
									</tr>
									
									
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1><%= thisOrder.getO_no() %></td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=new SimpleDateFormat("yyyy/MM/dd").format(thisOrder.getO_date()) %></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1><%= sUserId %></td>
										
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1>
												<input type="submit" value="삭제">
										</td>
									</tr>
								</table>
									
								<br/>	
								<table align=center  width=80% border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>상품 이미지</td>
										<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>상품명</td>
										<td width=112 height=25 align=center bgcolor="E6ECDE" class=t1>수 량</td>
										<td width=166 height=25  align=center bgcolor="E6ECDE" class=t1>가 격</td>
										<td width=50 height=25  align=center bgcolor="E6ECDE" class=t1>비 고</td>
									</tr>
									
									<!-- order item start -->
									
									<% 
									int tot_price = 0;
									for(OrderItem orderItem : thisOrder.getOrderItemList()) { 
									tot_price = orderItem.getOi_qty() * orderItem.getProduct().getP_price();
									%>
									<tr>
										<td width=290 height=50 align=center  bgcolor="ffffff" class=t1>
										<%= orderItem.getProduct().getP_image() %>
										</td>
										<td width=290 height=50 align=center  bgcolor="ffffff" class=t1>
										<a href='product_detail.jsp?p_no= <%= orderItem.getProduct().getP_no() %>'><%= orderItem.getProduct().getP_name() %></a>
										</td>
										
										<td width=110 height=26 align=center  bgcolor="ffffff" class=t1><%= orderItem.getOi_qty() %></td>
										
										<td width=150 height=26 align=center bgcolor="ffffff" class=t1><%= numberFormat.format(tot_price) %></td>
										<td width=60 height=26 align=center class=t1 bgcolor="ffffff"></td>
									</tr>
									<% }
									
									String order_tot_price = numberFormat.format(thisOrder.getO_price());
									%>
									
									<!-- order item end -->
									
									<tr>
										<td width=640 colspan=5 height=26  bgcolor="ffffff" class=t1>
										
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>TOTAL : <%= order_tot_price %> 원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center> 
										&nbsp;&nbsp;<a href=order_list.jsp
										class=m1>주문목록</a>
										&nbsp;&nbsp;<a href=product_list.jsp
										class=m1>계속 쇼핑하기</a>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>