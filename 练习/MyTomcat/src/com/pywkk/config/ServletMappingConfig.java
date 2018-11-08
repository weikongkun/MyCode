package com.pywkk.config;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
	public static List<ServletMapping> servletMappingList = new ArrayList<>();
	
	static {
		servletMappingList.add(new ServletMapping("DemoServlet_01", "/demo01", "com.pywkk.servlets.DemoServlet_01"));
		servletMappingList.add(new ServletMapping("DemoServlet_HelloWorld", "/HelloWorld", "com.pywkk.servlets.DemoServlet_HelloWorld"));
	}
}
