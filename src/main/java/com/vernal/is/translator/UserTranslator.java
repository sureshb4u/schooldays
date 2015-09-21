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
	
    /**
     * Translating UserDTO List to User List
     * @param userDTOList
     * @param locale
     * @return
     */
    public List<User> translateToUserList(List<UserDTO> userDTOList,String locale){
    	LOGGER.debug("Translating UserDTO List to User List");
		List<User> userList = new ArrayList<User>(); 
		if(userDTOList != null && !userDTOList.isEmpty()){
			for(UserDTO userDTO : userDTOList){
				User user = loginTranslator.translateToUser(userDTO, locale);
				userList.add(user);
			}
		}
		return userList;
    }
}
