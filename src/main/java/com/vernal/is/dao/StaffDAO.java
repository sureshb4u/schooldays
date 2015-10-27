package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StudentClassDTO;
import com.vernal.is.dto.StudentDTO;

public interface StaffDAO {

	public ResponseBean updateUser(StudentDTO studentDTO, Integer accessId);

	public ResponseBean deleteUser(Integer studentId, Integer accessId);

	public ResponseBean insertUser(StudentDTO studentDTO, Integer accessId) ;

	public StudentDTO getStudent(Integer studentId);

	public List<StudentDTO> getStudents(String role, String search,
			Integer standardId, Integer sectionId);

	public List<StudentClassDTO> getClassList(String role, Integer standardId,
			Integer sectionId);

	public List<StaffClassDTO> getClassListByStaffId(String role,
			Integer staffId);

}
