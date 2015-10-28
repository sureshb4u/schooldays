package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dao.StaffDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StudentClassDTO;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.util.CommonConstants;


@Component
public class StaffServices {

	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
	StaffDAO staffDAO;
	
	@Resource
	CommonService commonService ;
	/**
	 * 
	 * @param studentDTO
	 * @return
	 */
	public ResponseBean updateUser(StudentDTO studentDTO, Integer accessId) {
		studentDTO = getBasicIds(studentDTO);
		return staffDAO.updateUser(studentDTO, accessId);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseBean deleteUser(Integer studentId, Integer accessId) {
		return staffDAO.deleteUser(studentId, accessId);
	}

	/**
	 * 
	 * @param studentDTO
	 * @return
	 * @throws Exception 
	 */
	public ResponseBean createStudent(StudentDTO studentDTO, Integer accessId) throws Exception {
		studentDTO = getBasicIds(studentDTO);
		System.out.println("studentDTO>>>>>>>"+gson.toJson(studentDTO));
		return staffDAO.insertUser(studentDTO, accessId);
	}

	/**
	 * 
	 * @return
	 */
	public List<StudentDTO> getStudents(String role,String search,Integer standardId,Integer sectionId) {
		return staffDAO.getStudents(role,search, standardId,sectionId);
	}

	public List<StudentClassDTO> getClassList(String role,Integer standardId,Integer sectionId) {
		return staffDAO.getClassList(role, standardId,sectionId);
	}
	
	
	public List<StaffClassDTO> getClassListByStaffId (String role,Integer staffId) {
		return staffDAO.getClassListByStaffId(role, staffId);
	}

	public StudentDTO getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return staffDAO.getStudent(studentId);
	}

	
	public StudentDTO getBasicIds(StudentDTO studentDTO){
		GenderDTO genderDTO = null;
		ReligionDTO religionDTO =null;
		CommunityDTO communityDTO = null;
		if(studentDTO.getGender() != null){
			genderDTO = studentDTO.getGender() ;
			genderDTO.setId(commonService.getId(genderDTO.getGender(), CommonConstants.GENDER));
			studentDTO.setGender(genderDTO);
		}
	
		if(studentDTO.getReligion() != null){
			religionDTO = studentDTO.getReligion() ;
			religionDTO.setId(commonService.getId(religionDTO.getReligion(), CommonConstants.RELIGION));
			studentDTO.setReligion(religionDTO);
		}
		if(studentDTO.getCommunity() != null){
			communityDTO = studentDTO.getCommunity() ;
			communityDTO.setId(commonService.getId(communityDTO.getCommunity(), CommonConstants.COMMUNITY));
			studentDTO.setCommunity(communityDTO);
		}
	
		return studentDTO;
	}

}
