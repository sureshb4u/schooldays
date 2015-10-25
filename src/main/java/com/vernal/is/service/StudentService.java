/**
 * 
 */
package com.vernal.is.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.vernal.is.dto.StudentDTO;
import com.vernal.is.model.Class;
import com.vernal.is.model.Student;
import com.vernal.is.translator.StudentTranslator;
import com.vernal.is.util.CommonConstants;

/**
 * @author Vignesh
 * 
 */
@Component

public class StudentService extends BaseService{
	
	@Resource
	StudentTranslator studentTranslator;
	
	/**
	 * getStudentsList
	 * @param standardId
	 * @param sectionId
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<Student> getStudentsList(String standardId, String sectionId, HttpSession session) throws Exception {
		List<StudentDTO> studentDTOList = null; 
		List<Student> studentist = null; 
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
		
			ResponseEntity<Object> response = restTemplate.exchange( getAPIBaseURL()
							+ CommonConstants.STUDENTS_BASE_URL + CommonConstants.STANDARD_URL +"/" + standardId
							+ CommonConstants.SECTION_URL + "/" + sectionId,
							HttpMethod.GET, requestEntity, Object.class);
			
			studentDTOList = studentTranslator.convertToListOfStudentDTO(response.getBody()); 
			studentist = studentTranslator.translateToStudentList(studentDTOList);
			
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
			throw e;
		}
		return studentist;
		}

	/**
	 * 
	 * @param queryString 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	public Object getClassesList(Map<String, String> queryString, HttpSession session) throws Exception {
		String param ="";
		if(queryString != null){
			param = translateQueryParams(queryString);
		}
		
		try {
			HttpEntity<String> requestEntity = prepareGet(session); 
		
			ResponseEntity<Object> response = restTemplate.exchange( getAPIBaseURL()
							+ CommonConstants.STUDENTS_BASE_URL + CommonConstants.CLASSES_URL +"?"+ param,
							HttpMethod.GET, requestEntity, Object.class);
			
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
		}
	
	
}
