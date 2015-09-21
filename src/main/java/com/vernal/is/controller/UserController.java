package com.vernal.is.controller;

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
@RequestMapping("/user")
public class UserController extends BaseController{
	
	
	@Resource
	BaseController baseController;
	
	@Resource
	UserService userService;
	
	@Resource
	BaseService baseService;
	
	@RequestMapping(value = "/user",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  createUser(@RequestBody User user,HttpSession session){
		Object result=null;
		String organizationId = null;
		try{
			  String orgMnemonic = baseService.getOrganizationId();
			  organizationId = baseService.getOrganizationId(orgMnemonic, session);	
			  result = userService.createUser(user,organizationId,session);
		}catch(Exception ex){
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
	}
	
	
	
}
