package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.vernal.is.dao.UserDAO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.mapper.UserAuthenticationRowMapper;
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

	@Override
	public Object aurthentication(
			UserAuthenticationDTO userAuthenticationDTO) {
           UserDTO user = new UserDTO();	
			try {
				if (userAuthenticationDTO != null) {
					String sql = "SELECT * FROM user_authentication WHERE USER_NAME ="
				+userAuthenticationDTO.getUserName()+
				"and"
				+userAuthenticationDTO.getUserSecret();
					UserAuthenticationDTO userAuthentication = (UserAuthenticationDTO) getJdbcTemplate().query(sql, 
							new UserAuthenticationRowMapper());
					if (userAuthentication !=null) {
						
						
					} else {
						
					}
				}
			} catch (Exception ex) {
				logger.error("Exception in checkBillsNoExists -- " + ex);
				String exStr = ex.getMessage();
			}
			return user;
	}

}
