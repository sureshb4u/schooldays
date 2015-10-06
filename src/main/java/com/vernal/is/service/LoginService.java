package com.vernal.is.service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.model.User;
import com.vernal.is.translator.LoginTranslator;
import com.vernal.is.util.CommonConstants;

@Component
public class LoginService extends BaseService{
	
	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
	
	@Resource
	LoginTranslator loginTranslator;
	
	/***
	 * Authenticates the User from API.
	 * @param userName The String value of UserName (cannot be null).
	 * @param secret The String value of secret (cannot be null).
	 * @param session The HttpSession.
	 * @return user A not null {@link User}
	 * @throws Exception 
	 */
	public User userAuthentication(String userName,String secret, HttpSession session, String locale) throws IOException {	
		User user= new User();
		UserDTO userDTO = new UserDTO();
		UserAuthenticationDTO userAuthenticationDTO = loginTranslator.translateToUserAuthenticationDTO(userName, secret);
		String postString = gson.toJson(userAuthenticationDTO);
		System.out.println("postString>>>>>>>>>>."+postString);
		try {
			HttpEntity<String> entity = preparePost(postString, session);
			// This will authenticate the user
			System.out.println("ssssssssss");
			ResponseEntity<Object> response = restTemplate.exchange("http://180.215.113.236:8080/services/users/authenticate", 
							HttpMethod.POST, entity, Object.class);
			
			userDTO = loginTranslator.convertToUserDTO(userDTO);
			user = loginTranslator.translateToUser(userDTO, locale);
			System.out.println("user>>>>>>>>>>>>"+gson.toJson(user));
		}catch (IOException e) {
			throw e;
		}catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		}    
		return user;
	}
	
	/**
	 * Logout the authenticated users.
	 * @param session the HttpSession.  
	 * @throws Exception
	 */
	public void logout(HttpSession session) throws IOException{
		try{
			HttpEntity<String> entity = prepareDelete(session);
			// This will authenticate the user
			restTemplate.exchange(getAPIBaseURL()
				+ CommonConstants.ORGANIZATIONS_BASE_URL 
				+ CommonConstants.USERS_BASE_URL 
				+ CommonConstants.SESSION_BASE_URL,
				HttpMethod.DELETE, entity, Object.class);
			
		}catch (IOException e) {
			throw e;
		}catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		} 
	}
}
