package com.vernal.is.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.dao.UserDAO;
import com.vernal.is.model.UserList;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserDAO userDAO;

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
}
