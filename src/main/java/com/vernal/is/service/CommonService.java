package com.vernal.is.service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.vernal.is.util.CommonConstants;

@Component
public class CommonService extends BaseService {

	@Resource
	EmailService emailService;
	
	
	public String verifyEmail(String email, HttpSession session) throws Exception{
		ResponseEntity<Object> response = null;
		try {
			/*	HttpEntity<String> requestEntity = prepareGet(session); 
		
		response = restTemplate.exchange( getAPIBaseURL() + CommonConstants.COMMON_BASE_URL
							+ CommonConstants.EMAIL_VERIFICATION + CommonConstants.SLASH + email ,
							HttpMethod.GET, requestEntity, Object.class);
			*/
			//if(response.getBody().equals("SUCCESS")){
				
			//}
			
		} catch (RestClientException e) {
			e.printStackTrace();
			throw e;
		}
		return emailService.readyToSendEmail(email, CommonConstants.PASSWORD_RESET_SUBJECT, "Hello User,"+ CommonConstants.PASSWORD_RESET_CONTENT);
		}
}
