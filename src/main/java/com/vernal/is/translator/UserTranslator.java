/**
 * 
 */
package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.model.User;

/**
 * @author bashelu
 *
 */
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
     */
    public List<User> translateToUserList(List<UserDTO> userDTOList, String locale){
    	LOGGER.debug("Translating UserDTO List to User List");
		List<User> userList = new ArrayList<User>(); 
		if(userDTOList != null && !userDTOList.isEmpty()){
			for(UserDTO userDTO : userDTOList){
				User user = translateToUser(userDTO, locale);
				userList.add(user);
			}
		}
		return userList;
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
		if(userDTO != null){
			BeanUtils.copyProperties(userDTO, user);
			
			if(userDTO.getLastName()!=null && !userDTO.getLastName().isEmpty() && userDTO.getFirstName() !=null && !userDTO.getFirstName().isEmpty() ){
				user.setUserName(userDTO.getFirstName()+" "+userDTO.getLastName());
			}
			if(userDTO.getId()!=null){
				user.setId(userDTO.getId().toString());
			}
			if(userDTO.getDateOfBirth()!=null){
				user.setDateOfBirth(userDTO.getDateOfBirth().toString());
			}
			if(userDTO.getGender() != null){
				user.setGender(userDTO.getGender().getGender());
			}
		}
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO translateToUserDTO(User user){
		UserDTO userDTO = null;
		if(user != null){
			BeanUtils.copyProperties(user, userDTO);
			
			if(user.getDateOfBirth() != null){
				//userDTO.setDateOfBirth(dateOfBirth);
			}
		}
		return userDTO;
	}
}
