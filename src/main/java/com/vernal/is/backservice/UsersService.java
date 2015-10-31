package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dao.UserDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.RoleDTO;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.util.CommonConstants;

@Component
public class UsersService {

	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	@Resource
	UserDAO userDAO;
	
	@Resource
	CommonService commonService ;
	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	public ResponseBean updateUser(UserDTO userDTO, Integer acessId,  Integer userId) {
		userDTO = getBasicIds(userDTO);
		return userDAO.updateUser(userDTO, acessId, userId);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseBean deleteUser(Integer userId, Integer accessId) {
		return userDAO.deleteUser(userId, accessId);
	}

	/**
	 * 
	 * @param userDTO
	 * @return
	 * @throws Exception 
	 */
	public ResponseBean insertUser(UserDTO userDTO, Integer accessId) throws Exception {
		userDTO = getBasicIds(userDTO);
		System.out.println("userDTO>>>>>>>"+gson.toJson(userDTO));
		return userDAO.insertUser(userDTO, accessId);
	}

	/**
	 * 
	 * @return
	 */
	public List<UserDTO> getUsers(String role) {
		return userDAO.getUsers(role);
	}

	public UserDTO aurthentication(UserAuthenticationDTO userAuthenticationDTO) {
		// TODO Auto-generated method stub
		return userDAO.aurthentication(userAuthenticationDTO);
	}

	public UserDTO getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDAO.getUser(userId);
	}

	
	public UserDTO getBasicIds(UserDTO userDTO){
		GenderDTO genderDTO = null;
		RoleDTO roleDTO = null;
		ReligionDTO religionDTO =null;
		CommunityDTO communityDTO = null;
		DesignationDTO designationDTO = null;
		if(userDTO.getGender() != null){
			genderDTO = userDTO.getGender() ;
			genderDTO.setId(commonService.getId(genderDTO.getGender(), CommonConstants.GENDER));
			userDTO.setGender(genderDTO);
		}
		if(userDTO.getRole() != null){
			roleDTO = userDTO.getRole() ;
			roleDTO.setId(commonService.getId(roleDTO.getRole(), CommonConstants.ROLE));
			userDTO.setRole(roleDTO);
		}
		if(userDTO.getReligion() != null){
			religionDTO = userDTO.getReligion() ;
			religionDTO.setId(commonService.getId(religionDTO.getReligion(), CommonConstants.RELIGION));
			userDTO.setReligion(religionDTO);
		}
		if(userDTO.getCommunity() != null){
			communityDTO = userDTO.getCommunity() ;
			communityDTO.setId(commonService.getId(communityDTO.getCommunity(), CommonConstants.COMMUNITY));
			userDTO.setCommunity(communityDTO);
		}
		if(userDTO.getDesignation() != null){
			designationDTO = userDTO.getDesignation() ;
			designationDTO.setId(commonService.getId(designationDTO.getDesignation(), CommonConstants.DESIGNATION));
			userDTO.setDesignation(designationDTO);
		}
		return userDTO;
	}
}
