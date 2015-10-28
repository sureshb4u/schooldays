package com.vernal.is.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vernal.is.dao.StaffDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.StaffClassDTO;
import com.vernal.is.dto.StudentClassDTO;
import com.vernal.is.dto.StudentDTO;
import com.vernal.is.mapper.UserListRowMapper;
import com.vernal.is.util.CommonConstants;

public class StaffDAOImpl extends NamedParameterJdbcDaoSupport implements StaffDAO{

	@Override
	public ResponseBean updateUser(StudentDTO student, Integer accessId) {
		ResponseBean responseBean = new ResponseBean();
		
		String UPDATE_STUDENT = "UPDATE `student` SET ";
		if(student.getFirstName() !=null){
			UPDATE_STUDENT = UPDATE_STUDENT + "`FIRST_NAME` = "+student.getFirstName();
	        }
	        if(student.getLastName() != null){
	         UPDATE_STUDENT = UPDATE_STUDENT + "`LAST_NAME` = "+student.getLastName();
	        }
	        if(student.getDateOfBirth() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT +  "`DATE_OF_BIRTH`="+student.getDateOfBirth();
	        }
	        if(student.getStandard() != null && student.getStandard().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + " `ID_STANDARD`= "+student.getStandard().getId();
	        }
	        if(student.getSection() != null && student.getSection().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`ID_SECTION`= "+student.getSection().getId();
	        }
	        if(student.getYear() != null && student.getYear().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`ID_YEAR`= "+student.getYear().getId();
	        }
	        if(student.getAge() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`AGE`= "+student.getAge();
	        }
	        if(student.getFatherName() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`FATHER_NAME`= "+student.getFatherName();
	        }
	        if(student.getBloodGroup() != null && student.getBloodGroup().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`ID_BLOOD_GROUP`= "+student.getBloodGroup().getId();
	        }
	        if(student.getCommunity() != null && student.getCommunity().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + "`ID_COMMUNITY` = "+student.getCommunity().getId();
	        }
	        if(student.getReligion() != null && student.getReligion().getId() != null){
	        UPDATE_STUDENT = UPDATE_STUDENT + " `ID_RELIGION` = "+student.getReligion().getId();
	        }
	        UPDATE_STUDENT = UPDATE_STUDENT + " `IS_DELETED` = 0";
	        UPDATE_STUDENT = UPDATE_STUDENT + "`UPDATED_BY`="+accessId;
	        UPDATE_STUDENT = UPDATE_STUDENT +") WHERE ID = "+student.getId();
	 	   try{
			   KeyHolder keyHolder = new GeneratedKeyHolder();
			   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
					   student);
			if(student != null)
			getNamedParameterJdbcTemplate().update(UPDATE_STUDENT, namedParameters, keyHolder );
			Number idStudent = keyHolder.getKey();
			student.setId(idStudent.intValue());
			System.out.println("id ------------>"+idStudent);
			if(idStudent != null){
				responseBean.setStatus("SUCCESS");
		        responseBean.setMessage("The new student is added successfully");
			}
		   }catch(Exception e){
			   e.printStackTrace();
			   responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		   }
		return responseBean;
	}

	@Override
	public ResponseBean deleteUser(Integer studentId, Integer accessId) {
		ResponseBean responseBean = new ResponseBean();
		String DELETE_STUDENT = "UPDATE `student` SET IS_DELETED = 0 WHERE ID = ?";
		try{
		getJdbcTemplate().update(DELETE_STUDENT);
		responseBean.setStatus("SUCCESS");
	    responseBean.setMessage("The new student is added successfully");
		
		}catch(Exception e){
			   e.printStackTrace();
			   responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		   }
		return responseBean;
	}

	@Override
	public ResponseBean insertUser(StudentDTO student, Integer accessId) {
		
		ResponseBean responseBean = new ResponseBean();
		String CREATE_STUDENT = "INSERT INTO `student`(";
		        if(student.getFirstName() !=null){
				CREATE_STUDENT = CREATE_STUDENT + "`FIRST_NAME`, ";
		        }
		        if(student.getLastName() != null){
		         CREATE_STUDENT = CREATE_STUDENT + "`LAST_NAME`, ";
		        }
		        if(student.getDateOfBirth() != null){
		        CREATE_STUDENT = CREATE_STUDENT +  "`DATE_OF_BIRTH`,";
		        }
		        if(student.getStandard() != null && student.getStandard().getId() != null){
		        CREATE_STUDENT = CREATE_STUDENT + " `ID_STANDARD`, ";
		        }
		        if(student.getSection() != null && student.getSection().getId() != null){
		        CREATE_STUDENT = CREATE_STUDENT + "`ID_SECTION`, ";
		        }
		        if(student.getYear() != null && student.getYear().getId() != null){
		        CREATE_STUDENT = CREATE_STUDENT + "`ID_YEAR`, ";
		        }
		        if(student.getAge() != null){
		        CREATE_STUDENT = CREATE_STUDENT + "`AGE`, ";
		        }
		        if(student.getFatherName() != null){
		        CREATE_STUDENT = CREATE_STUDENT + "`FATHER_NAME`, ";
		        }
		        if(student.getBloodGroup() != null && student.getBloodGroup().getId() != null){
		        		CREATE_STUDENT = CREATE_STUDENT + "`ID_BLOOD_GROUP`, ";
		        }
		        if(student.getCommunity() != null && student.getCommunity().getId() != null){
		        		CREATE_STUDENT = CREATE_STUDENT + "`ID_COMMUNITY`,";
		        }
		        if(student.getReligion() != null && student.getReligion().getId() != null){
		        	CREATE_STUDENT = CREATE_STUDENT + " `ID_RELIGION`,";
		        }
		        CREATE_STUDENT = CREATE_STUDENT + " `IS_DELETED`,";
		        CREATE_STUDENT = CREATE_STUDENT + " `CREATED_ON`, ";
		        CREATE_STUDENT = CREATE_STUDENT + "`CREATED_BY`) VALUES (";
		        
		        		 if(student.getFirstName() !=null){
		     				CREATE_STUDENT = CREATE_STUDENT + student.getFirstName()+",";
		     		        }
		     		        if(student.getLastName() != null){
		     		         CREATE_STUDENT = CREATE_STUDENT + student.getLastName()+",";
		     		        }
		     		        if(student.getDateOfBirth() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT +  student.getDateOfBirth()+",";
		     		        }
		     		        if(student.getStandard() != null && student.getStandard().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getDateOfBirth()+",";
		     		        }
		     		        if(student.getSection() != null && student.getSection().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getDateOfBirth()+",";
		     		        }
		     		        if(student.getYear() != null && student.getYear().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getYear()+",";
		     		        }
		     		        if(student.getAge() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getAge()+",";
		     		        }
		     		        if(student.getFatherName() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getFatherName()+",";
		     		        }
		     		        if(student.getBloodGroup() != null && student.getBloodGroup().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getBloodGroup()+",";
		     		        }
		     		        if(student.getCommunity() != null && student.getCommunity().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getCommunity()+",";
		     		        }
		     		        if(student.getReligion() != null && student.getReligion().getId() != null){
		     		        CREATE_STUDENT = CREATE_STUDENT + student.getReligion()+",";
		     		        }	
		     		       CREATE_STUDENT = CREATE_STUDENT + ")";
		     		      try{
		     				   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
		     						   student);
		     				   
		     				if(student.getId() != null){
		     				   getNamedParameterJdbcTemplate().update(CREATE_STUDENT, namedParameters );
		     					responseBean.setStatus("SUCCESS");
		     					responseBean.setMessage("The new student is added successfully");
		     				}
		     			   }catch(Exception e){
		     				   responseBean.setStatus("FAILED");
		     				   String eStr = e.getMessage();
		     					responseBean.setMessage(eStr);
		     			   }
		     			   return responseBean;
	}

	@Override
	public StudentDTO getStudent(Integer studentId) {
		
		StudentDTO studentList = new StudentDTO();
		String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE ID = "+studentId;
		return studentList = getJdbcTemplate().query(GET_STUDENT_BY_ID,new ResultSetExtractor<StudentDTO>(){

			@Override
			public StudentDTO extractData(ResultSet rs) throws SQLException,
					DataAccessException {

				StudentDTO student = new StudentDTO();
				student.setId(rs.getInt("ID"));
			 
			    
				student.setFirstName(rs.getString("FIRST_NAME"));
				student.setLastName(rs.getString("LAST_NAME"));
				student.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
			/*	student.setEmailAddresses(rs.getString("EMAIL_ADDRESS"));
				student.setExperience(rs.getInt("EXPERIENCE"));
				student.setBioGraphy(rs.getString("BIO_GRAPHY"));
				student.setDateOfJoining(rs.getDate("DATE_OF_JOINING"));*/
				student.setFatherName(rs.getString("FATHER_NAME"));
				student.setAge(rs.getInt("AGE"));
				
					GenderDTO gender = new GenderDTO();
					gender.setId(rs.getInt("ID"));
					gender.setGender(rs.getString("GENDER"));
					student.setGender(gender);
					CommunityDTO community = new CommunityDTO();
					community.setId(rs.getInt("ID"));
					community.setCommunity("COMMUNITY");
					student.setCommunity(community);
					ReligionDTO religion = new ReligionDTO();
					religion.setId(rs.getInt("ID"));
					religion.setReligion("RELIGION");
					student.setReligion(religion);
					return student;
				
			}
			
		});
	}

	@Override
	public List<StudentDTO> getStudents(String role, String search,
			Integer standardId, Integer sectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentClassDTO> getClassList(String role, Integer standardId,
			Integer sectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StaffClassDTO> getClassListByStaffId(String role,
			Integer staffId) {
		// TODO Auto-generated method stub
		return null;
	}

}
