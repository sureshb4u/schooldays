package com.vernal.is.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.backservice.UsersService;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
    @RequestMapping(value = "/authentication", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  Authentication(HttpEntity<String> entity) throws Exception {
        UserDTO user = new UserDTO();
        String postString = entity.getBody();
        UserAuthenticationDTO userAuthenticationDTO = gson.fromJson(postString, UserAuthenticationDTO.class);
        user = userService.aurthentication(userAuthenticationDTO);
        System.out.println("user>>>>>>>"+gson.toJson(user));
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }


	@RequestMapping(value = "/{role}/users", method = RequestMethod.GET )
	@ResponseBody
	public List<UserDTO> getUsers(HttpEntity<String> entity, @PathVariable String role, HttpSession session)  {
		System.out.println("Get Users>>>>>>>>>>");
		System.out.println(entity.getHeaders());
		System.out.println(session.getAttribute(CommonConstants.SESSION_USER_ID));
		return userService.getUsers(role);
	}
	
	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public UserDTO getUser(@PathVariable Integer userId) throws Exception {
		System.out.println("Get User>>>>>>>>>>");
		return userService.getUser(userId);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object saveUsers(@ModelAttribute("user") UserDTO user,
            Map<String, Object> model) throws Exception {
		System.out.println("saveUsers>>>>>>>>>>");
		return "success";
	}
	@RequestMapping(value = "/{accessId}/createUser", headers="Accept=*/*", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addUsers( @PathVariable(value ="accessId") String accessId, HttpEntity<String> entity) throws Exception {
		 String postString = entity.getBody();
		
	        UserDTO userDTO = gson.fromJson(postString, UserDTO.class);
	       System.out.println("userDTO>>>>>dfsf>>>>>>>>>."+gson.toJson(userDTO));
		Integer userid = null ;
		if(accessId != null && !accessId.isEmpty()){
			System.out.println("accessId>>>>>>>"+accessId);
			 userid = Integer.valueOf(accessId);
			 userService.insertUser(userDTO, userid);
		}
		return new ResponseEntity<String>("SUCESS", HttpStatus.OK);
	}


	@RequestMapping(value = "updateUser/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean updateBills(@PathVariable Integer userId, @RequestBody UserDTO userDTO, HttpSession session) throws Exception {
		ResponseBean responseBean = new ResponseBean();
		responseBean = userService.updateUser(userDTO, userId);
		return responseBean;
	}

	@RequestMapping(value = "deleteBill/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseBean deleteBill(@PathVariable Integer userId, HttpSession session) throws Exception {
		ResponseBean responseBean = new ResponseBean();
		responseBean = userService.deleteUser(userId, userId);
		return responseBean;
	}

}
