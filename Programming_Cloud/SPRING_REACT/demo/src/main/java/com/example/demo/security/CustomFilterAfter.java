package com.example.demo.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomFilterAfter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
		System.out.println("Response : " + url);
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
