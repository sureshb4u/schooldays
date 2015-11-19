package com.vernal.is.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.backservice.StaffServices;
import com.vernal.is.dto.ClassesDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.util.CommonConstants;

/**
 * @author Vignesh
 * 
 */
@Controller
@RequestMapping(CommonConstants.STUDENTS_BASE_URL)
public class StaffController{

	@Resource
	StaffServices staffServices;

	
	 @ResponseBody
	 public List<StaffClassDTO> getStudentsList(@PathVariable(value="standardId")Integer standardId, 
			 @PathVariable(value="sectionId")Integer sectionId, HttpServletRequest request, HttpSession session){
		 String role = "ADMIN";
				 //request.getHeader(CommonConstants.SESSION_USERROLE);
		// String staffid= request.getHeader(CommonConstants.SESSION_USER_ID);
		 Integer staffId= Integer.valueOf("24"); 
		 List<StaffClassDTO> staffClassList = null;
		 staffClassList =  staffServices.getClassList(role, staffId,standardId,sectionId);
		  return staffClassList;
	 }
	 
	 /**
	  * */
     @RequestMapping(value = "/classes", method = RequestMethod.GET)
	 @ResponseBody
	 public List<ClassesDTO> getAllClassList( HttpServletRequest request, HttpSession session){
		  return staffServices.getAllClassList();
	 }
	 
     @RequestMapping(value =  CommonConstants.STANDARD_URL+"/{standardId}"+ CommonConstants.SECTION_URL+"/{sectionId}",
	 method = RequestMethod.GET)
			@ResponseBody
			public List<StudentDTO> getStudents(@PathVariable(value="standardId")Integer standardId, @PathVariable(value="sectionId")Integer sectionId,
					 @RequestParam( value="search" , required = false) String search, HttpServletRequest requests)  {
				String role = "ADMIN";
						 //request.getHeader(CommonConstants.SESSION_USERROLE);
				//if(role != null){
					return staffServices.getStudents(role, search, standardId, sectionId);
			}
			
			@RequestMapping(value = "/getStudent/{studentId}", method = RequestMethod.GET)
			@ResponseBody
			public StudentDTO getUser(@PathVariable(value ="studentId") Integer studentId) throws Exception {
				System.out.println("Get User>>>>>>>>>>");
				return staffServices.getStudent(studentId);
			}
			
			@RequestMapping(value = "/createStudent", headers="Accept=*/*", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public ResponseEntity<?> addUsers(@RequestBody StudentDTO studentDTO) throws Exception {
				 String accessId ="22";
				Integer userid = null ;
				if(accessId != null && !accessId.isEmpty()){
					System.out.println("accessId>>>>>>>"+accessId);
					 userid = Integer.valueOf(accessId);
					 staffServices.createStudent(studentDTO, userid);
				}
				return new ResponseEntity<String>("SUCESS", HttpStatus.OK);
			}


			@RequestMapping(value = "updateStudent/{studentId}", method = RequestMethod.PUT)
			@ResponseBody
			public ResponseBean updateBills(@PathVariable Integer studentId, @RequestBody StudentDTO studentDTO, HttpSession session, HttpServletRequest request) throws Exception {
				Integer accessId = Integer.valueOf(request.getHeader(CommonConstants.SESSION_USER_ID));
				ResponseBean responseBean = new ResponseBean();
				responseBean = staffServices.updateStudent(studentDTO, accessId);
				return responseBean;
			}

			@RequestMapping(value = "deleteStudent/{studentId}", method = RequestMethod.DELETE)
			@ResponseBody
			public ResponseBean deleteStaff(@PathVariable Integer studentId,HttpServletRequest request, HttpSession session) throws Exception {
				Integer accessId = Integer.valueOf(request.getHeader(CommonConstants.SESSION_USER_ID));
				ResponseBean responseBean = new ResponseBean();
				responseBean = staffServices.deleteStudent(studentId, accessId);
				return responseBean;
			}
	 
	 
}
