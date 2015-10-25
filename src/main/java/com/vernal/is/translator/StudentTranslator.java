/**
 * 
 */
package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.model.Student;

/**
 * @author Vignesh
 *
 */
@Component
public class StudentTranslator  extends BaseTranslator{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentTranslator.class);
	
	public List<StudentDTO> convertToListOfStudentDTO(Object object) {
		LOGGER.debug("COnverting json to list of StudentDTO");
		Type listType = new TypeToken<List<StudentDTO>>() {}.getType();
		List<StudentDTO> studentDTOList = gson.fromJson(translateObjectToJson(object), listType);
		return studentDTOList;
	}

	public List<Student> translateToStudentList(List<StudentDTO> studentDTOList) {
		LOGGER.debug("Translate list of StudentDTO to list of Student");
		List<Student> studentList = null;
		if(studentDTOList != null && !studentDTOList.isEmpty()){
			studentList = new ArrayList<Student>();
			for(StudentDTO studentDTO : studentDTOList){
				studentList.add(translateToStudent(studentDTO));
			}
		}
		return studentList;
	}

	private Student translateToStudent(StudentDTO studentDTO) {
		LOGGER.debug("Translate StudentDTO to Student");
		Student student = null;
		if(studentDTO!= null){
			student = new Student();
			BeanUtils.copyProperties(studentDTO, student);
			
		}
		return student;
	}
	
}
