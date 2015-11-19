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
import com.vernal.is.model.Section;
import com.vernal.is.model.Standard;
import com.vernal.is.model.Student;
import com.vernal.is.model.Class;
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
			if(studentDTO.getEmailAddress() != null){
				student.setEmailAddresses(studentDTO.getEmailAddress());
			}
			if(studentDTO.getStandard() != null && studentDTO.getSection() != null){
				Class classes = new Class(); Standard standard = new Standard(); Section section = new Section();
				if(studentDTO.getStandard().getId() != null){
					standard.setId(studentDTO.getStandard().getId());
				}
				if(studentDTO.getStandard().getStandard() != null){
					standard.setStandard(studentDTO.getStandard().getStandard());
				}
				if(studentDTO.getSection().getId() != null){
					section.setId(studentDTO.getSection().getId());
				}
				if(studentDTO.getStandard().getStandard() != null){
					section.setSection(studentDTO.getSection().getSection());
				}
				classes.setStandard(standard);
				classes.setSection(section);
			}
		
		}
		return student;
	}
	
}
