package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;
import com.itwill.summer.mvc.Controller;

public class GuestRomoveActionController implements Controller {
	private GuestService guestService;
	public GuestRomoveActionController() {
		guestService = new GuestService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_noStr = request.getParameter("guest_no");
				int deleteRowCount = guestService.delete(Integer.parseInt(guest_noStr));
				forwardPath="redirect:guest_list.do";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
