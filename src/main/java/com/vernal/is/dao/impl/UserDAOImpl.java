package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.vernal.is.dao.UserDAO;
import com.vernal.is.mapper.UserRowMapper;
import com.vernal.is.model.User;

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	private static final String GET_USERS = "SELECT * FROM user";

	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			userList = getJdbcTemplate().query(GET_USERS, new UserRowMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userList;
	}

}
