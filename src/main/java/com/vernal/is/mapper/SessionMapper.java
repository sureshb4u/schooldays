package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.GenderDTO;
import com.vernal.is.dto.UserDTO;

public class SessionMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs == null) {
			return null;
		}

	
	    UserDTO user = new UserDTO();
		user.setId(rs.getInt("ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		//user.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
		user.setEmailAddresses(rs.getString("EMAIL_ADDRESS"));
		//user.setExperience(rs.getInt("EXPERIENCE"));
		//user.setBioGraphy(rs.getString("BIO_GRAPHY"));
		//user.setDateOfJoining(rs.getDate("DATE_OF_JOINING"));
		//user.setFatherName(rs.getString("FATHER_NAME"));
		//user.setAge(rs.getInt("AGE"));
		if(rs.getInt("ID_DESIGNATION")!= 0){
			DesignationDTO designation = new DesignationDTO();
			designation.setId(rs.getInt("ID"));
			designation.setDesignation(rs.getString("DESIGNATION"));
		    user.setDesignation(designation);
		}
		if((rs.getInt("ID_GENDER")) != 0){
			GenderDTO gender = new GenderDTO();
			gender.setId(rs.getInt("ID"));
			gender.setGender(rs.getString("GENDER"));
			user.setGender(gender);
		}
		/*if(rs.getInt("ID_COMMUNITY")){
			CommunityDTO community = new CommunityDTO();
			community.setId(rs.getInt("ID"));
			community.setCommunity("COMMUNITY");
			user.setCommunity(community);
		}*/
		return user;
	}
}
