package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.LeaveManagementDTO;

public class LeaveManagementRowMapper implements RowMapper<LeaveManagementDTO>{

	@Override
	public LeaveManagementDTO mapRow(ResultSet rs, int arg1)
			throws SQLException {
		if (rs == null) {
			return null;
		}
		LeaveManagementDTO leaveManagementDTO = new LeaveManagementDTO();
		leaveManagementDTO.setId(rs.getInt("ID"));
		//leaveManagementDTO.setIdStaff(rs.getInt("ID_STATUS"));
		leaveManagementDTO.setStartTime(rs.getTimestamp("START_TIME"));
		leaveManagementDTO.setEndTime(rs.getTimestamp("END_DATE"));
		leaveManagementDTO.setReason(rs.getString("REASON"));
		leaveManagementDTO.setIsTaken(rs.getInt("IS_TAKEN"));
		//leaveManagementDTO.setIdFormStatus(rs.getInt("ID_FORM_STATUS"));
		return leaveManagementDTO;
	}

}
