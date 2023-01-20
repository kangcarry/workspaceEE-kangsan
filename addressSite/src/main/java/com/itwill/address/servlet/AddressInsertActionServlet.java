package com.itwill.address.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressInsertActionServlet
 */
@WebServlet("/address_insert_action.do")
public class AddressInsertActionServlet extends HttpServlet {
	
	private AddressService addressService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_main.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService.insert()메쏘드실행
			 * 4.address_list.do 로 redirection
			 */
			//0.요청객체encoding설정
			response.setContentType("text/html;charset:UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			//1.파라메타받기
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			 //2.AddressService객체생성
			this.addressService = new AddressService();
			
			//3.AddressService.insert()메쏘드실행
			addressService.insert(new Address(0, name, phone, address));
			
			//4.address_list.do 로 redirection
			response.sendRedirect("address_list.do");
			
				
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
