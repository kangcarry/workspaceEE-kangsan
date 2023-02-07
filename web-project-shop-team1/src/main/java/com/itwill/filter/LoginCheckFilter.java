package com.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	/**
	<filter>
  	<filter-name>LoginCheck</filter-name>
    <filter-class>com.itwill.filter.LoginCheckFilter</filter-class>
  </filter>
    <filter-mapping>
      <filter-name>LoginCheck</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
 
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	/**
	 * ServletRequest객체에 web.xml에서 전달된 인코딩을 설정하는 메써드.
	 */
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		httpRequest.setCharacterEncoding("UTF-8");
		HttpSession session = httpRequest.getSession(false);
		boolean login = false;
		if(session != null) {
		   if(session.getAttribute("sUserId") != null) {
			   login = true;    // 세션변수가  null이 아닐경우 true로 설정.
		  }
		}
		  
		if(login) {
		    // 세션변수가 null이 아닐경우, 필터 체인을 거친 후, 요청한 페이지로 이동한다.
			chain.doFilter(request, response);
		}
		else {
		   // 세션변수가 null일 경우, 로그인 폼으로 이동한다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user_login_form.jsp");
			dispatcher.forward(request, response);
		 }
	}
	public void destroy() {
	}
	
}
