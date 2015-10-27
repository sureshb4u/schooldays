package com.vernal.is.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.model.DropDownValue;
import com.vernal.is.translator.CommonTranslator;
import com.vernal.is.util.CommonConstants;

@Component
public class CommonServices extends BaseService {

	@Resource
	EmailService emailService;
	
	@Resource
	CommonTranslator commonTranslator;
	
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
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	
	public List<DropDownValue> getCommunityList(HttpSession session){
		ResponseEntity<Object> response = null;
		List<DropDownValue> dropDownList = null;
		HttpEntity<String> requestEntity;
		try {
			requestEntity = prepareGet(session);
			
			response = restTemplate.exchange( getAPIBaseURL() + CommonConstants.COMMON_BASE_URL + CommonConstants.SLASH
					+ CommonConstants.COMMUNITY ,
					HttpMethod.GET, requestEntity, Object.class);
			List<CommunityDTO> communityDTOList = commonTranslator.convertToCommunityDTOList(response.getBody());
			dropDownList = commonTranslator.translateToCommunityDropDownList(communityDTOList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dropDownList;
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	
	public List<DropDownValue> getReligionList(HttpSession session){
		ResponseEntity<Object> response = null;
		List<DropDownValue> dropDownList = null;
		HttpEntity<String> requestEntity;
		try {
			requestEntity = prepareGet(session);
			
			response = restTemplate.exchange( getAPIBaseURL() + CommonConstants.COMMON_BASE_URL + CommonConstants.SLASH
					+ CommonConstants.RELIGION ,
					HttpMethod.GET, requestEntity, Object.class);
			List<ReligionDTO> reigionDTOList = commonTranslator.convertToReligionDTOList(response.getBody());
			dropDownList = commonTranslator.translateToReligionDropDownList(reigionDTOList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dropDownList;
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	
	public List<DropDownValue> getDesignationList(HttpSession session){
		ResponseEntity<Object> response = null;
		List<DropDownValue> dropDownList = null;
		HttpEntity<String> requestEntity;
		try {
			requestEntity = prepareGet(session);
			
			response = restTemplate.exchange( getAPIBaseURL() + CommonConstants.COMMON_BASE_URL + CommonConstants.SLASH
					+ CommonConstants.DESIGNATION ,
					HttpMethod.GET, requestEntity, Object.class);
			List<DesignationDTO> designationDTO = commonTranslator.convertToDesignationDTOList(response.getBody());
			dropDownList = commonTranslator.translateToDesignationDropDownList(designationDTO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dropDownList;
	}
}
