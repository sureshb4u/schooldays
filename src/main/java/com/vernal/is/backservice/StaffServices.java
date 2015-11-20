package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dao.StaffDAO;
import com.vernal.is.dto.ClassesDTO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.SectionDTO;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StandardDTO;
import com.vernal.is.dto.StudentAddressDTO;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.dto.StudentPhoneNumberDTO;
import com.vernal.is.dto.StudentRelationDTO;
import com.vernal.is.util.CommonConstants;


@Component
public class StaffServices {

	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
	@Resource
	StaffDAO staffDAO;
	
	@Resource
	CommonService commonService ;
	/**
	 * 
	 * @param studentDTO
	 * @return
	 */
	public ResponseBean updateStudent(StudentDTO studentDTO, Integer accessId) {
		studentDTO = getBasicIds(studentDTO);
		return staffDAO.updateStudent(studentDTO, accessId);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResponseBean deleteStudent(Integer studentId, Integer accessId) {
		return staffDAO.deleteStudent(studentId, accessId);
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
		return staffDAO.createStudent(studentDTO, accessId);
	}

	/**
	 * 
	 * @return
	 */
	public List<StudentDTO> getStudents(String role, String search, Integer standardId, Integer sectionId) {
		System.out.println("role---"+role + "standardId--------"+standardId+"sectionId-------"+sectionId);
		return staffDAO.getStudents(role, standardId, sectionId);
	}

	public List<StaffClassDTO> getClassList(String role,Integer staffId) {
		return staffDAO.getClassList(role,staffId);
	}
	

	public StudentDTO getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return staffDAO.getStudent(studentId);
	}

	
	public StudentDTO getBasicIds(StudentDTO studentDTO){
		GenderDTO genderDTO = null;
		ReligionDTO religionDTO =null;
		CommunityDTO communityDTO = null;
		StandardDTO standard = null;
		SectionDTO section = null; 
		StudentRelationDTO relation = null;
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
		if(studentDTO.getStandard() != null){
			standard = studentDTO.getStandard() ;
			standard.setId(commonService.getId(standard.getStandard(), CommonConstants.STANDARD));
			studentDTO.setStandard(standard);
		}
		if(studentDTO.getSection() != null){
			section = studentDTO.getSection() ;
			section.setId(commonService.getId(section.getSection(), CommonConstants.SECTION));
			studentDTO.setSection(section);
		}
		if(studentDTO.getPhoneNumbers()!= null){
			for(StudentPhoneNumberDTO phone: studentDTO.getPhoneNumbers()){
			 relation = phone.getStudentRelation();
				relation.setId(commonService.getId(relation.getRelation(),CommonConstants.RELATION));
				phone.setStudentRelation(relation);
			}
			if(studentDTO.getAddresses() != null){
				for(StudentAddressDTO address: studentDTO.getAddresses()){
				 relation = address.getStudentRelation();
					relation.setId(commonService.getId(relation.getRelation(),CommonConstants.RELATION));
					address.setStudentRelation(relation);
				}
			}
			
		}
	
		return studentDTO;
	}

	public List<ClassesDTO> getAllClassList() {
		// TODO Auto-generated method stub
		return staffDAO.getAllClassList();
	}

}
