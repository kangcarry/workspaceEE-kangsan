<%@page import="com.itwill.shop.board.BoardService"%>
<%@page import="com.itwill.shop.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("board_list.jsp");
		return;
	}
	 
	Board board=new Board();
	board.setBoard_title(request.getParameter("title"));
	board.setUser_id(request.getParameter("writer"));
	board.setBoard_content(request.getParameter("content"));
	
	BoardService.getInstance().create(board);
	response.sendRedirect("board_list.jsp");
%>
