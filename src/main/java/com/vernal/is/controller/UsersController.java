package com.vernal.is.controller;

import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dao.UserDAO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.model.UserList;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserDAO userDAO;

	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
	@RequestMapping(value = "/getUsersList", method = RequestMethod.GET)
	@ResponseBody
	public UserList getUsers() throws Exception {
		System.out.println("Get Users>>>>>>>>>>");
		UserList userList = new UserList();
		userList.setUsers(userDAO.getUsers());
		return userList;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object getUsers1() throws Exception {
		System.out.println("Get Users>>>>>>>>>>");
		return "WELCOME";
	}
	
		@RequestMapping(value = "addBills", method = RequestMethod.POST)
		@ResponseBody
		public ResponseBean addBills(@RequestBody UserAuthenticationDTO userAuthenticationDTO) throws Exception {
			ResponseBean responseBean = new ResponseBean();
		//	responseBean = userDAO.aurthentication(userAuthenticationDTO);
			return responseBean;
		}
	}

