package com.vernal.is.view.controller;

import java.util.List;
import java.util.Map;

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

import com.vernal.is.model.Student;
import com.vernal.is.service.StudentService;
import com.vernal.is.util.CommonConstants;

/**
 * @author Vignesh
 * 
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

	@Resource
	StudentService studentService;

	 @RequestMapping(value = "/standard/{standardId}/section/{sectionId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getStudentsList(@PathVariable(value="standardId")String standardId, 
			 @PathVariable(value="sectionId")String sectionId, HttpSession session){
		 List<Student> studentsList = null;
		try {
			studentsList = studentService.getStudentsList(standardId, sectionId, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/classes", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> getClassesList(HttpSession session) {
		 Object classesList = null;
		try {
			String userRole = session.getAttribute(CommonConstants.SESSION_USERROLE).toString();
			System.out.println("userRole----------"+userRole);
			if(userRole.equalsIgnoreCase("ADMIN")){
				classesList = studentService.getClassesList(session);
			}else{
				classesList = studentService.getClassesListByStaff(session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<Object>(classesList, HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value ="/create")
	 public ResponseEntity<?> createStudent(@RequestBody Student student, HttpSession session){
		 Object obj = null;
		 System.out.println("student--"+gson.toJson(student));
		 try {
			 obj = studentService.createStudent(student, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(obj , HttpStatus.ACCEPTED);
	 }

}
