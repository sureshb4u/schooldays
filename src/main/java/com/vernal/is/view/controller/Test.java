package com.vernal.is.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vernal.is.service.EmailService;


public class Test {
	static
	HttpServletRequest httpServletRequest;
	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
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
