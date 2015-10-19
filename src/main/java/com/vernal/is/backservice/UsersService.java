package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vernal.is.dao.UserDAO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;

@Component
public class UsersService {

	@Resource
	UserDAO userDAO;
	
	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	public ResponseBean updateUser(UserDTO userDTO, Integer userId) {
		return userDAO.updateUser(userDTO, userId);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseBean deleteUser(Integer userId, Integer accessId) {
		return userDAO.deleteUser(userId, accessId);
	}

	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	public ResponseBean insertUser(UserDTO userDTO, Integer accessId) {
		return userDAO.insertUser(userDTO, accessId);
	}

	/**
	 * 
	 * @return
	 */
	public List<UserDTO> getUsers() {
		return userDAO.getUsers();
	}

	public UserDTO aurthentication(UserAuthenticationDTO userAuthenticationDTO) {
		// TODO Auto-generated method stub
		return userDAO.aurthentication(userAuthenticationDTO);
	}

	public UserDTO getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDAO.getUser(userId);
	}


}
