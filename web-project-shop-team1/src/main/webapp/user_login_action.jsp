<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.shop.user.User"%>
<%@page import="com.itwill.shop.user.exception.PasswordMismatchException"%>
<%@page import="com.itwill.shop.user.exception.UserNotFoundException"%>
<%@page import="com.itwill.shop.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	String user_id=null;
	String user_password=null;
	try{
		user_id=request.getParameter("user_id");
		user_password=request.getParameter("user_password");
		UserService userService=new UserService();
		User loginUser = userService.login(user_id, user_password);
		session.setAttribute("sUserId", user_id);
		session.setAttribute("sUser", loginUser);
		response.sendRedirect("shop_main.jsp");
		
	}catch(UserNotFoundException e){
		/*********************case3[forward]****************
		request.setAttribute("msg1", e.getMessage());
		request.setAttribute("fuser",new User(userId,password,"",""));
		RequestDispatcher rd=
				request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		***********************************/
		/***************case1[redirect]****************
		response.sendRedirect("user_login_form.jsp?msg1="+URLEncoder.encode(e.getMessage(), "UTF-8"));
		************************************/
		/*****************case2[정상응답]**********************/
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		/********************************************/
		
	}catch(PasswordMismatchException e){
		
		/*********************case3[forward]****************
		request.setAttribute("msg2", e.getMessage());
		request.setAttribute("fuser",new User(userId,password,"",""));
		RequestDispatcher rd=
				request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		***********************************/
		/***************case1[redirect]****************
		response.sendRedirect("user_login_form.jsp?msg2="+URLEncoder.encode(e.getMessage(), "UTF-8"));
		************************************/
		/*****************case2[정상응답]********************/
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		/********************************************/
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>








