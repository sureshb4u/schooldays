package com.vernal.is.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import com.vernal.is.model.Student;
import com.vernal.is.model.User;
import com.vernal.is.translator.LoginTranslator;
import com.vernal.is.translator.UserTranslator;
import com.vernal.is.util.CommonConstants;

/**
 * User : Lupna
 * Date : 08/21/2015
 */
@Component
public class UserService  extends BaseService{

	
	@Resource
	LoginTranslator loginTranslator;
	
	@Resource
	UserTranslator userTranslator;
	
	public Object createUser(User user, String organizationId,HttpSession session) throws IOException {
		UserDTO userDTO = loginTranslator.translateToUserDTO(user);
		String postString = gson.toJson(userDTO);
		try {
			HttpEntity<String> entity = preparePut(postString,session);
			ResponseEntity<Object> response = restTemplate.exchange(
					getAPIBaseURL() + CommonConstants.ORGANIZATIONS_BASE_URL+CommonConstants.SLASH+organizationId
					+ CommonConstants.USER_BASE_URL,HttpMethod.POST,entity ,Object.class);
			return response.getBody();
		}catch (IOException e) {
			throw e;
		} catch (JsonSyntaxException e) {
			throw e;
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}

	/**
	 * Getting Clients List
	 * @param queryString
	 * @param organizationId
	 * @param session
	 * @param locale
	 * @return
	 * @throws IOException
	 */
	public List<User> getUsersList(Map<String, String> queryString,String organizationId, HttpSession session, String locale) throws IOException {
		List<UserDTO> userDTOList = null;
		List<User> userList = null;
		String parameterList=null;
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
			parameterList=translateQueryParams(queryString);
			System.out.println("api---"+getAPIBaseURL() 
							+ CommonConstants.ORGANIZATIONS_BASE_URL+ CommonConstants.SLASH+ organizationId +
							CommonConstants.PERSONS_BASE_URL +"?"+parameterList.toString());
			ResponseEntity<Object> response =
							restTemplate.exchange("http://10.213.50.68:9000"
							+ CommonConstants.ORGANIZATIONS_BASE_URL+ CommonConstants.SLASH+ organizationId +
							CommonConstants.PERSONS_BASE_URL +"?"+parameterList.toString(),							
							HttpMethod.GET,requestEntity, Object.class);
			userDTOList = userTranslator.translateToUserDTOList(response.getBody());
			userList = userTranslator.translateToUserList(userDTOList, locale);
			return userList;
		}catch (IOException e) {
			throw e;
		}catch (JsonSyntaxException e) {
			throw e;
		}catch (HttpClientErrorException e) {
			throw e;
		}
	}

	public Organization getStaffsList(String organizationId, HttpSession session) throws JsonSyntaxException, IOException {
		File file = new File("staff-list.json");
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
