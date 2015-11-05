package com.vernal.is.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vernal.is.backservice.StudentsService;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.util.CommonConstants;

/**
 * @author Vignesh
 * 
 */
@Controller
@RequestMapping(CommonConstants.STUDENTS_BASE_URL)
public class StudentsController{

	@Resource
	StudentsService studentsService;

	 @RequestMapping(value =  CommonConstants.STANDARD_URL+"/{standardId}"+ CommonConstants.SECTION_URL+"/{sectionId}",
			 method = RequestMethod.GET)
	 @ResponseBody
	 public List<StudentDTO> getStudentsList(@PathVariable(value="standardId")String standardId, 
			 @PathVariable(value="sectionId")String sectionId){

		 List<StudentDTO> studentDTOList = null;
			studentDTOList = studentsService.getStudentsList(standardId, sectionId);
		  return studentDTOList;
	 }
	 
	 @RequestMapping(value = CommonConstants.CLASSES_URL, method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<?> getClassesList(@RequestParam(value="standardId", required=false) String standardId){
		 if(standardId!= null ){
			 
		 }else{
			 
		 }
		 
		 return null;
	 }
	 
}
