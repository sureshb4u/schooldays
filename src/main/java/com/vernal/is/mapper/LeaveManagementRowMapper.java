package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.FormStatusDTO;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.UserDTO;

public class LeaveManagementRowMapper implements RowMapper<LeaveManagementDTO>{

	@Override
	public LeaveManagementDTO mapRow(ResultSet rs, int arg1)
			throws SQLException {
		if (rs == null) {
			return null;
		}
		LeaveManagementDTO leaveManagementDTO = new LeaveManagementDTO();
		leaveManagementDTO.setId(rs.getInt("ID"));
		leaveManagementDTO.setStartTime(rs.getTimestamp("START_TIME").toString());
		leaveManagementDTO.setEndTime(rs.getTimestamp("END_TIME").toString());
		leaveManagementDTO.setReason(rs.getString("REASON"));
		leaveManagementDTO.setIsTaken(rs.getInt("IS_TAKEN"));
		FormStatusDTO formStatus = new FormStatusDTO();
		formStatus.setId(rs.getInt("ID_FORM_STATUS"));
		formStatus.setStatus(rs.getString("STATUS"));
		leaveManagementDTO.setFormStatus(formStatus);
		UserDTO user = new UserDTO();
		user.setId(rs.getInt("ID_STAFF"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		leaveManagementDTO.setStaff(user);
		return leaveManagementDTO;
	}

}
