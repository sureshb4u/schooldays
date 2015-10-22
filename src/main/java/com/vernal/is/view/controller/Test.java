package com.vernal.is.view.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.Preconditions;
import com.vernal.is.service.EmailService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.CommonUtil;


public class Test {
	static
	HttpServletRequest httpServletRequest;
	
	public static void main(String args[]) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(CommonConstants.DATE_DD_MMMM_YYYY);
			Date d = new Date();
			Timestamp time = new Timestamp(d.getTime());
			System.out.println("dateto timestamp>>>>>"+time);
			String date = formatter.format(time);
			System.out.println("timestamp to date>>>>.."+date);

			
	}
	public static void toBeginningOfTheDay(Calendar calendar) {
        Preconditions.checkNotNull(calendar, "Calendar");
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }
	public static Date formatgivenStringToDate(String strDate, String fromFormat, String toFormat){
		SimpleDateFormat formatter = new SimpleDateFormat(fromFormat);
		try {
			Date date = formatter.parse(strDate);
			System.out.println(date);
			System.out.println("date>>>>>>>>>>."+date);
			SimpleDateFormat formatter2 = new SimpleDateFormat(toFormat);
			String dateStr = formatter2.format(date);
			System.out.println("dateStr>>>>>>>>"+dateStr);
			Date last_date_date = new SimpleDateFormat(toFormat).parse(dateStr);
			String rF =	new SimpleDateFormat(toFormat).format(last_date_date);
			Date dateToFormat = formatter2.parse(dateStr);
			System.out.println("dateToFormat>>>>>>>>>>>>"+rF);
			return dateToFormat;
		} catch (ParseException e) {
			e.printStackTrace();;
		}
		return null;
	}
	
	/*
	public  static String checkDate(){
		    Date today = Calendar.getInstance().getTime();
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		    String folderName = formatter.format(today);
		    System.out.println("Folder Name = " + folderName);
		return 
	}*/
	public static String stringFeilds(String str){
		return "'"+str+"'";
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
