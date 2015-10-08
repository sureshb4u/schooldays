package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.model.User;

public interface UserDAO {
	public List<User> getUsers();

	public Object aurthentication(UserAuthenticationDTO userAuthenticationDTO);

}
