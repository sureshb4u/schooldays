package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.DomainReferenceDTO;
import com.vernal.is.dto.OrganizationRoleDTO;
import com.vernal.is.dto.RoleDTO;
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
	
	/**
	 * Converts to user
	 * @param userDTO
	 * @param locale
	 * @return user
	 */
	public User translateToUser(UserDTO userDTO, String locale){
		LOGGER.info("Converting UserDTO model to User");
		User user= new User();
		if(userDTO.getProfile() != null){
			if(userDTO.getProfile().getDateOfBirth()!=null){
				user.setDateOfBirth(userDTO.getProfile().getDateOfBirth());
			}
			if(userDTO.getProfile().getGender() != null){
				user.setGender(commonUtil.getLocaleValue(userDTO.getProfile().getGender().getDisplays(), locale));
			}
			if(userDTO.getProfile().getFirstName() !=null && !userDTO.getProfile().getFirstName().isEmpty()){
				user.setFirstName(userDTO.getProfile().getFirstName());
			}
			if(userDTO.getProfile().getLastName()!=null && !userDTO.getProfile().getLastName().isEmpty()){
				user.setLastName(userDTO.getProfile().getLastName());
			}
		}
		if(userDTO.getFirstName() !=null && !userDTO.getFirstName().isEmpty()){
			user.setFirstName(userDTO.getFirstName());
		}
		if(userDTO.getLastName()!=null && !userDTO.getLastName().isEmpty()){
			user.setLastName(userDTO.getLastName());
		}
		if(userDTO.getOrgId()!=null){
			user.setOrgId(userDTO.getOrgId().toString());
		}
		if(userDTO.getPersonId()!=null){
			user.setPersonId(userDTO.getPersonId().toString());
		}
		if(userDTO.getSessionToken()!=null && !userDTO.getSessionToken().isEmpty()){
			user.setSessionToken(userDTO.getSessionToken());
		}
		if(userDTO.getUserName() != null && !userDTO.getUserName().isEmpty()){
			user.setUserName(userDTO.getUserName());
		}
		if(userDTO.getOrgRoleDTOList()!=null && !userDTO.getOrgRoleDTOList().isEmpty()){
			for(OrganizationRoleDTO orgroleDTO : userDTO.getOrgRoleDTOList()){
				for(RoleDTO roleDTO : orgroleDTO.getRoles()){
					if(roleDTO.getName() != null){
						user.setUserRole(commonUtil.getLocaleValue(roleDTO.getName().getDisplays(),locale));	
					}
					
				}
			}
		}
		return user;
	}

	/**
	 * Translates User to UserDTO
	 * @param user The object of User
	 * @return userDTO The object of UserDTO
	 */
	public UserDTO translateToUserDTO(User user){
		UserDTO userDTO = new UserDTO();
		if(user.getFirstName() != null && !user.getFirstName().isEmpty()){
			userDTO.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null && !user.getLastName().isEmpty()){
			userDTO.setLastName(user.getLastName());
		}
		if(user.getDateOfBirth() != null && !user.getDateOfBirth().isEmpty()){
			userDTO.setDateOfBirth(user.getDateOfBirth());
		}
		if(user.getGender() != null && !user.getGender().isEmpty()){
			DomainReferenceDTO gender = new DomainReferenceDTO();
			gender.setKey(user.getGender() .toUpperCase());
			userDTO.setGender(gender);
		}
	/*	if(user.getOrgId() != null && !user.getOrgId().isEmpty()){
			userDTO.setOrgId(UUID.fromString(user.getOrgId()));
		}*/
		if(user.getPersonId() != null && !user.getPersonId().isEmpty()){
			userDTO.setPersonId(UUID.fromString(user.getPersonId()));
		}
		if(user.getUserName() != null && !user.getUserName() .isEmpty()){
			userDTO.setUserName(user.getUserName());
		}
	 return userDTO;
	}
}