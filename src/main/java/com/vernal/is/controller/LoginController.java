package com.vernal.is.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.model.Login;
import com.vernal.is.model.Roles;
import com.vernal.is.model.User;
import com.vernal.is.service.LoginService;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.util.MessageUtils;

@Controller
public class LoginController extends BaseController{

	
	@Resource
	private BaseController baseController;
	
	@Resource
	private LoginService loginService;
	
	@Resource
	private UserController userController;
	
	/**
	 * Checking user authentication in login
	 * @param login
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/authentication",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authentication(@RequestBody Login login,HttpSession session) throws IOException {
		User user = new User();
			try{ 
					if(login.getUserName()!=null&&!login.getUserName().isEmpty()&&login.getUserSecret()!=null&&!login.getUserSecret().isEmpty()) {
						user = loginService.userAuthentication(login.getUserName(), login.getUserSecret(), session, baseController.locale);
						System.out.println(gson.toJson(user));
						System.out.println("inside session........");
					/*	if(user.getSessionToken() != null && user.getSessionToken().isEmpty())
							session.setAttribute(CommonConstants.SESSION_TOKEN, user.getSessionToken());
						if(user.getOrgId() != null && user.getOrgId().isEmpty())
							session.setAttribute(CommonConstants.SESSION_ORG_ID, user.getOrgId().toString());
						if(user.getPersonId() != null && user.getPersonId().isEmpty())
							session.setAttribute(CommonConstants.SESSION_PERSON_ID, user.getPersonId());
						if(user.getUserName() != null && user.getUserName().isEmpty())
							session.setAttribute(CommonConstants.SESSION_USERNAME, user.getUserName());
						if(user.getUserRole()!=null && !user.getUserRole().isEmpty()){
							session.setAttribute(CommonConstants.SESSION_USERROLE, user.getUserRole());*/
							 session.setAttribute(CommonConstants.SESSION_USERROLE, "Vernalis Admin");
					/*	}
						if(user.getFirstName() != null && user.getFirstName().isEmpty())
							session.setAttribute(CommonConstants.SESSION_FIRSTNAME, user.getFirstName());
						if(user.getLastName() != null && user.getLastName().isEmpty())
							session.setAttribute(CommonConstants.SESSION_LASTNAME, user.getLastName());*/
					 }
			}catch(Exception exception){
				return new ResponseEntity<>(setCustomExceptionHandler(exception, MessageUtils.getMessage("error.invalid.login")), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserRoles",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserRoles(HttpSession session) throws IOException {
		Roles roles = new Roles();
		try{ 
			roles = baseController.getRoleBasedPermission(session);
		}catch(Exception exception){
			return new ResponseEntity<>(setCustomExceptionHandler(exception, MessageUtils.getMessage("error.invalid.login")), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Roles>(roles,HttpStatus.OK);
	}
	
	/**
	 * User Logout 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/logout",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> logout(HttpSession session) throws IOException {
    	if(session.getAttribute(CommonConstants.SESSION_TOKEN) != null){
    		try{
    			loginService.logout(session);
    		} catch(Exception exception){
    			return new ResponseEntity<>(setCustomExceptionHandler(exception, MessageUtils.getMessage("error.user.logout")), HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    	session.removeAttribute(CommonConstants.SESSION_TOKEN);
    	session.removeAttribute(CommonConstants.SESSION_ORG_ID);
    	session.removeAttribute(CommonConstants.SESSION_PERSON_ID);
    	session.removeAttribute(CommonConstants.SESSION_USERNAME);
    	session.removeAttribute(CommonConstants.SESSION_USERROLE);
    	session.removeAttribute(CommonConstants.SESSION_FIRSTNAME);
    	session.removeAttribute(CommonConstants.SESSION_LASTNAME);
    	session.invalidate();
    	return new ResponseEntity<>(baseController.setResponse(MessageUtils.getMessage("user.logout.success"),HttpStatus.OK.toString()),HttpStatus.OK);
	}
	
	/**
	 * Checking unauthorized and trigger
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/unauthorized",method = RequestMethod.GET,	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> unauthorized(HttpSession session) throws IOException {
		session.invalidate();
	return new ResponseEntity<>(baseController.setResponse(MessageUtils.getMessage("error.user.unauthorized"),HttpStatus.UNAUTHORIZED.toString()),HttpStatus.UNAUTHORIZED);
	}
}
