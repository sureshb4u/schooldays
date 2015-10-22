package com.vernal.is.util;

public class CommonConstants {

	//Set session variable
	public static final String SESSION_TOKEN = "_stk";
	public static final String SESSION_ORG_ID="_orgId";
	public static final String XORG_ID= "X-Org-ID";
	public static final String X_AUTH_TOKEN = "X-Auth-Token";
	
	public static final String LOCALE_EN_US="en-US";
	public static final String ISO_DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ssZ";
	public static final String DATE_FORMAT="yyyy-dd-MM";
	public static final String DATE_DD_MMMM_YYYY = "dd MMMM, yyyy";
	//Login variable
	public static final String LOGIN_PAGE = "index";
	
	//Organization URL
	public static final String ORGANIZATIONS_BASE_URL = "/organizations";
	public static final String USERS_BASE_URL = "/users";
	public static final String SESSION_BASE_URL = "/session";
	public static final String USER_BASE_URL = "/user";
	public static final String ORGANIZATION_BASE_URL = "/organization";
	
	//Session variable
	public static final String SESSION_PERSON_ID="_pId";
	public static final String SESSION_USER_ID = "userId";
	public static final String SESSION_FIRSTNAME="_fn";
	public static final String SESSION_LASTNAME="_ln";
	public static final String SESSION_USERROLE="_rn";
	public static final String SESSION_TIMEZONE="_tz";
	public static final String SESSION_USERNAME="_una";
	public static final String SLASH="/";
	
	
	//Json file name
	public final static String ROLE_BASED_NAVIGATION_MENU = "role-based-menu.json";
	public static final String RELATIONSHIP_TYPE = "relationshipType";
	public static final String RELATIONSHIPS_BASE_URL = "/relationships";
	public static final String TYPE_KEY = "typeKey";
	public static final String PERSONS_BASE_URL = "/persons";
	public static final String ROLE_TYPE = "roleType";
	public static final String ROLE_BASE_URL = "/role";
	
	String toAddr = "viki19nesh@gmail.com";
	public static final String FROMADDRESS = "viki19nesh@gmail.com";

	// email subject
	public static final String  CREDENTIALS = "School Days Credentials";
	public static final String  USERNAME ="Your Login Id is "; 
	public static final String  PASSWORD ="Your password is "; 
	// email body
	public static final String FOOTER = "There you go.. You got an account in schooldays.. Let's understand details on how schooldays works, if"
			+ "you have any further doubts fee free to contact us -- By Support Team";
	public static final String CREATE_USERS_BASEURL = "/createUser";
	public static final String SESSION_EMAILADDRESS = "emailAddress";
	public static final String STATUS_PENDING = "PENDING";
	public static final String STATUS_DECLINED = "DECLINED";
	public static final String STATUS_APPROVED = "APPROVED";
	public static final String ROLE_ADMIN = "ADMIN";
	
}
