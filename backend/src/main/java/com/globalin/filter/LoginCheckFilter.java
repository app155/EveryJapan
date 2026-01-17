package com.globalin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.PatternMatchUtils;

public class LoginCheckFilter implements Filter {
	private static final String[] WHITE_LIST = { "/", "/test/*", "/css/**", "/js/**" }; 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter Init!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		System.out.println("DOFILTER: " + req.getRequestURI());
		
		if (isWhiteList(req.getRequestURI())) {
			chain.doFilter(req, res);
			return;
		}
		
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			res.sendRedirect("/test/testLogin");
			return;
		}
		
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		System.out.println("Filter destroyed!");
	}
	
	private boolean isWhiteList(String url) {
		System.out.println("!@#!@#!@#$!@#!@#!@#" + PatternMatchUtils.simpleMatch(WHITE_LIST, url));
		
		return PatternMatchUtils.simpleMatch(WHITE_LIST, url);
	}

}
