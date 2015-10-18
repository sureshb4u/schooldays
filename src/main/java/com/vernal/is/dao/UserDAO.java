package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;

public interface UserDAO {

	public List<UserDTO> getUsers();
	
	public UserDTO getUser(Integer userId);
	
    public UserDTO aurthentication(UserAuthenticationDTO userAuthenticationDTO);

	 public ResponseBean insertUser(UserDTO user, Integer accessId);

	 public ResponseBean updateUser(UserDTO user, Integer userId);

	public ResponseBean deleteUser(Integer userId, Integer accessId);
	
}
