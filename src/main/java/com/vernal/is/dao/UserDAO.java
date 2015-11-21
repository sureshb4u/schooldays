package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;

public interface UserDAO {

	
	public UserDTO getUser(Integer userId);
	
    public UserDTO aurthentication(UserAuthenticationDTO userAuthenticationDTO);

	 public ResponseBean insertUser(UserDTO user, Integer accessId) throws Exception;

	 public ResponseBean updateUser(UserDTO user, Integer acessId, Integer userId);

	public ResponseBean deleteUser(Integer userId,Integer phoneNumberId,Integer addressId, Integer accessId);

	public List<UserDTO> getUsers(String role);
	
}
