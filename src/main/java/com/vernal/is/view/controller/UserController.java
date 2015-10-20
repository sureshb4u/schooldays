package com.vernal.is.view.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vernal.is.model.Organization;
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
	
	@RequestMapping(value = "/getStaffsList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  getStaffsList(HttpSession session){
		Organization result = null;
		String organizationId = null;
		try{
			  result = userService.getStaffsList(organizationId,session);
		}catch(Exception ex){
			System.out.println("errrorrrrrrrr0");
			return new ResponseEntity<>(baseController.setResponse(MessageUtils.getMessage("error.create.user"),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	@RequestMapping(value = "/{orgId}/users",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClientsList(@PathVariable(value = "orgId")String organizationId,
			@RequestParam(value = "typeKey", required=false)String typeKey,HttpSession session)throws IOException {
		 List<User> userList = null;
		 Map<String, String> queryString = new TreeMap<String, String>();
		 if(typeKey !=null && !typeKey.isEmpty()){
				queryString.put(CommonConstants.TYPE_KEY, typeKey);
			}
			try{
			userList = userService.getUsersList(queryString,organizationId,session,locale);
		}catch(Exception ex){
			return new ResponseEntity<>(setCustomExceptionHandler(ex, MessageUtils.getMessage("error.getting.users")),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}//
	
	@RequestMapping(value = "/createStaff", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  createStaff(@RequestBody User user, HttpSession session){
		System.out.println("json>>>>>>>>>>>>"+gson.toJson(user));
		String userId =(String) session.getAttribute("userId");
		try {
			Object obj = userService.createUser(user, userId, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
