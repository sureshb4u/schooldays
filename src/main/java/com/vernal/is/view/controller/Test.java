package com.vernal.is.view.controller;

import javax.servlet.http.HttpServletRequest;


public class Test {
	static
	HttpServletRequest httpServletRequest;
	public static void main(String[] args) {
		HttpServletRequest request =null;
		String str = getServiceURL(request);
		System.out.println(str);
	}
	public static String getServiceURL(HttpServletRequest request){
	
	String ip = request.getContextPath();
	System.out.println("ip>>>>>>>>"+ip);
	int portNo = request.getLocalPort();
	System.out.println("portNo>>>>>>>>>>"+portNo);
	
	return ip+"/"+portNo;
	}
}
