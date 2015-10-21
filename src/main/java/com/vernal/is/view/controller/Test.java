package com.vernal.is.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Date;

import com.vernal.is.service.EmailService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.CommonUtil;


public class Test {
	static
	HttpServletRequest httpServletRequest;
	
	public static void main(String args[]) {
 
		
	}
	
	
	public static void dateFormatter() throws ParseException{
		CommonUtil common = new CommonUtil();
		Date d = common.formatgivenStringToDate("21 October, 2015", CommonConstants.DATE_DD_MMMM_YYYY, CommonConstants.DATE_FORMAT);
		System.out.println("date>>>>>>>>>>"+d);
	}
	
	
	@SuppressWarnings("resource")
	public void mailcheck(){
		// Spring Bean file you specified in /src/main/resources folder
				String crunchifyConfFile = "restview-servlet.xml";
				ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
		 
				// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
				EmailService emailService =  (EmailService) context.getBean("emailService");
				String toAddr = "viki19nesh@gmail.com";
				String fromAddr = "viki19nesh@gmail.com";
		 
				// email subject
				String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";
		 
				// email body
				String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
				emailService.readyToSendEmail(toAddr, fromAddr, subject, body);
	}
}
