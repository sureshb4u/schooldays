package com.vernal.is.translator;

import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.model.User;
import com.vernal.is.util.CommonUtil;

@Component
public class LoginTranslator extends BaseTranslator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTranslator.class);
	
	@Resource
	CommonUtil commonUtil;

	
	/**
	 * Converts userName and secret to UserAuthenticationDTO
	 * @param userName The String value of UserName (cannot be null).
	 * @param secret  The String value of password (cannot be null).
	 * @return userAuthenticationDTO
	 */
	public UserAuthenticationDTO translateToUserAuthenticationDTO(String userName, String secret){
		LOGGER.info("Translating username & password to UserAuthenticationDTO");
		UserAuthenticationDTO userAuthenticationDTO = new UserAuthenticationDTO();
		userAuthenticationDTO.setUserName(userName);
		userAuthenticationDTO.setUserSecret(secret);
		return userAuthenticationDTO;
	}
	
	/**
	 * Converts to UserDTO
	 * @param object
	 * @return userDTO
	 */
	public UserDTO convertToUserDTO(Object object) {
		LOGGER.info("Converting response Response model to UserDTO");
		Type type = new TypeToken<UserDTO>() {}.getType();
		UserDTO userDTO = gson.fromJson(translateObjectToJson(object), type);
		return userDTO;
	}
	
}