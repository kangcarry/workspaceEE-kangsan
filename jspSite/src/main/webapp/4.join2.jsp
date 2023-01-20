<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		/*
		 * GET방식으로 요청이 들어오면 4.join.jsp로 방향재지정(redirection)
		 */
		 response.sendRedirect("4.join1.jsp");
		return;
	}
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String addr=request.getParameter("addr");
	String[] favorites = request.getParameterValues("favorite");
%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 align="center">가입정보결과</h3><hr>
	<table width='50%'>
		<tr>
			<th width = 30%>항목</th>
			<th width = 50%>입력값</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><%=pass%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
			
	
	</table>


</body>
</html>