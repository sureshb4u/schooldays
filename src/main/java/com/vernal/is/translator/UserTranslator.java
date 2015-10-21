/**
 * 
 */
package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.dto.UserRoleDTO;
import com.vernal.is.model.User;
import com.vernal.is.util.CommonConstants;


@Component
public class UserTranslator extends BaseTranslator{
	
	@Resource
	LoginTranslator loginTranslator;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTranslator.class);
	
	/**
	 * Translate json response to UserDTO
	 * @param object
	 * @return
	 */
	public List<UserDTO> translateToUserDTOList(Object object) {
		LOGGER.debug("Translate json to UserDTO");
		Type listType = new TypeToken<List<UserDTO>>() {}.getType();
		List<UserDTO> userDTOList = gson.fromJson(translateObjectToJson(object), listType);
		return userDTOList;
	}
	
	public UserDTO translateToUserDTO(Object object) {
		LOGGER.debug("Translate json to UserDTO");
		Type listType = new TypeToken<UserDTO>() {}.getType();
		UserDTO userDTO = gson.fromJson(translateObjectToJson(object), listType);
		return userDTO;
	}
	
	
    /**
     * Translating UserDTO List to User List
     * @param userDTOList
     * @param locale
     * @return
     * @throws ParseException 
     */
    public List<User> translateToUserList(List<UserDTO> userDTOList, String locale) throws ParseException{
    	LOGGER.debug("Translating UserDTO List to User List");
		List<User> userList = new ArrayList<User>(); 
		if(userDTOList != null && !userDTOList.isEmpty()){
			for(UserDTO userDTO : userDTOList){
				userList.add(translateToUser(userDTO, locale));
			}
		}
		return userList;
    }
    
    /**
	 * Converts to user
	 * @param userDTO
	 * @param locale
	 * @return user
     * @throws ParseException 
	 */
	public User translateToUser(UserDTO userDTO, String locale) throws ParseException{
		LOGGER.info("Converting UserDTO model to User");
		User user= new User();
		if(userDTO != null){
			BeanUtils.copyProperties(userDTO, user);
			user.setUserName(userDTO.getFirstName()+" "+userDTO.getLastName());
			if(userDTO.getDateOfBirth()!=null){
				user.setDateOfBirth(commonUtil.formatDateTogiven( userDTO.getDateOfBirth(), CommonConstants.DATE_DD_MMMM_YYYY));
			}
			if(userDTO.getDateOfJoining()!=null){
				user.setDateOfJoining(commonUtil.formatDateTogiven(userDTO.getDateOfJoining(), CommonConstants.DATE_DD_MMMM_YYYY));
			}
			if(userDTO.getGender() != null){
			//	user.setGender(userDTO.getGender().getGender());
			}
		}
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws ParseException 
	 */
	public UserDTO translateToUserDTO(User user) throws ParseException{
		UserDTO userDTO = null;
		if(user != null){
			userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			if(user.getDateOfBirth() != null){
				System.out.println("user.getDateOfBirth()>>>>>>."+user.getDateOfBirth());
				userDTO.setDateOfBirth(commonUtil.formatgivenStringToDate(user.getDateOfBirth() , CommonConstants.DATE_DD_MMMM_YYYY, CommonConstants.DATE_FORMAT));
				System.out.println(">>>>>>>>>>"+userDTO.getDateOfBirth());
			}
			if(user.getDateOfJoining() != null){
				userDTO.setDateOfJoining(commonUtil.formatgivenStringToDate(user.getDateOfJoining() , CommonConstants.DATE_DD_MMMM_YYYY, CommonConstants.DATE_FORMAT));
			}
			UserRoleDTO userRole = new UserRoleDTO();
			userRole.setId(3);
			userDTO.setRoles(userRole);
			GenderDTO gender = new GenderDTO();
			gender.setId(1);
			userDTO.setGender(gender);
		}
		return userDTO;
	}
}
