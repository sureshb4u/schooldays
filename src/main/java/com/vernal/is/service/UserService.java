package com.vernal.is.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.JsonSyntaxException;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.model.Organization;
import com.vernal.is.model.User;
import com.vernal.is.translator.LoginTranslator;
import com.vernal.is.translator.UserTranslator;
import com.vernal.is.util.CommonConstants;

/**
 * User : Vignesh2p
 * Date : 08/21/2015
 */
@Component
public class UserService  extends BaseService {

	
	@Resource
	LoginTranslator loginTranslator;
	
	@Resource
	UserTranslator userTranslator;
	
	/**
	 * Getting Clients List
	 * @param queryString
	 * @param organizationId
	 * @param session
	 * @param locale
	 * @return
	 * @throws IOException
	 */
	public List<User> getUsersList(Map<String, String> queryString, String organizationId, HttpSession session, String locale) throws IOException {
		List<UserDTO> userDTOList = null;
		List<User> userList = null;
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
			ResponseEntity<Object> response =
							restTemplate.exchange(getAPIBaseURL()
							+ CommonConstants.USERS_BASE_URL + CommonConstants.USERS_BASE_URL ,
							HttpMethod.GET, requestEntity, Object.class);
			System.out.println("response.getBody()>>>>>>>"+gson.toJson(response.getBody()));
			userDTOList = userTranslator.translateToUserDTOList(response.getBody());
			userList = userTranslator.translateToUserList(userDTOList, locale);
		}catch (IOException e) {
			e.printStackTrace();
			throw e;
		}catch (JsonSyntaxException e) {
			e.printStackTrace();
			throw e;
		}catch (HttpClientErrorException e) {
			e.printStackTrace();
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 
	 * 
	 * @param user
	 * @param userID
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws IOException
	 */
	public Object createUser(User user, String userID, HttpSession session) throws ParseException, IOException {
		UserDTO userDTO = userTranslator.translateToUserDTO(user);
		String postString = gson.toJson(userDTO);
		System.out.println("postString>>>>"+postString);
		try {
			HttpEntity<String> entity = preparePost(postString, session);
			ResponseEntity<Object> response = restTemplate.exchange(getAPIBaseURL() 
							+ CommonConstants.SLASH + CommonConstants.USERS_BASE_URL + CommonConstants.SLASH 
							+ userID + CommonConstants.CREATE_USERS_BASEURL, HttpMethod.POST, entity ,Object.class);
			
			return response.getBody();
		} catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}
	
	/**
	 * 
	 * @param userId
	 * @param locale
	 * @param session
	 * @return
	 * @throws IOException
	 */
	public User getUserById(String userId, String locale, HttpSession session) throws IOException{
		UserDTO userDTO = null; User user = null;
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
			ResponseEntity<Object> response =
							restTemplate.exchange(getAPIBaseURL()
							+ CommonConstants.USERS_BASE_URL + CommonConstants.USERS_BASE_URL ,
							HttpMethod.GET, requestEntity, Object.class);
			userDTO = userTranslator.translateToUserDTO(response.getBody());
			user = userTranslator.translateToUser(userDTO, locale);
		}catch (IOException e) {
			throw e;
		}catch (JsonSyntaxException e) {
			throw e;
		}catch (HttpClientErrorException e) {
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	public Organization getStaffsList(String organizationId, HttpSession session) throws JsonSyntaxException, IOException {
		File file = new File("staff-list.json");
		System.out.println("staffffffffffffffffff");
		InputStream inputStream = null;
		Organization org = null;
		if (!file.exists()) {
			/* if not exists, reading file from appln file path */
			inputStream =  this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"com/vernal/is/properties/staff-list.json");
		} else {
			/* file exists, reading file */
			try {
				inputStream = new FileInputStream("staff-list.json");
			} catch (FileNotFoundException exception) {
				throw exception;
			}
		}
		org = gson.fromJson(commonUtil.getStringFromInputStream(inputStream), Organization.class);
		System.out.println("staff list-=------" + gson.toJson(org));
		//UserDAOImpl userDAO = new UserDAOImpl();
	//	System.out.println("userDAO.getUserInfo()"+gson.toJson(userDAO.getUserInfo()));
		return org;
	}

}
