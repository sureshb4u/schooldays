package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.ClassesDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StudentDTO;

public interface StaffDAO {


	public ResponseBean deleteStudent(Integer studentId, Integer accessId);

	public ResponseBean createStudent(StudentDTO studentDTO, Integer accessId) ;
	
	public ResponseBean updateStudent(StudentDTO studentDTO, Integer accessId);

	public StudentDTO getStudent(Integer studentId);

	public List<StudentDTO> getStudents(String role, Integer standardId, Integer sectionId);

	public List<StaffClassDTO> getClassList(String role,Integer staffId);

	public List<ClassesDTO> getAllClassList();

}
