package com.vernal.is.view.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.model.User;
import com.vernal.is.service.BaseService;
import com.vernal.is.service.UserService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.MessageUtils;

/**
 * User : Vignesh
 * Date : 08/21/2015
 */
@Controller
@RequestMapping("/staff")
public class UserController extends BaseController{
	
	
	@Resource
	BaseController baseController;
	
	@Resource
	UserService userService;
	
	@Resource
	BaseService baseService;
	
	

	@RequestMapping(value = "/staffs",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStaffsList(HttpSession session) throws IOException {
		 List<User> userList = null;
		 Map<String, String> queryString = new TreeMap<String, String>();
			try{
				userList = userService.getUsersList(CommonConstants.ROLE_NT_STAFF,session,locale);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<>(setCustomExceptionHandler(ex, MessageUtils.getMessage("error.getting.users")),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/teachingStaffs",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTeachingStaffs(HttpSession session) throws IOException {
		 List<User> userList = null;
			try{
				userList = userService.getUsersList(CommonConstants.ROLE_T_STAFF,session,locale);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<>(setCustomExceptionHandler(ex, MessageUtils.getMessage("error.getting.users")),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/createStaff", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  createStaff(@RequestBody User user, HttpSession session){
		System.out.println("json>>>>>>>>>>>>"+gson.toJson(user));
		String userId =(String) session.getAttribute("userId");
		try {
			Object obj = userService.createUser(user, "1", session);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
