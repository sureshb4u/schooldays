package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.FormStatusDTO;

public class FormStatusRowMapper implements RowMapper<FormStatusDTO> {

	@Override
	public FormStatusDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs == null) {
			return null;
		}
		FormStatusDTO formStatusDTO = new FormStatusDTO();
		formStatusDTO.setId(rs.getInt("ID"));
		formStatusDTO.setStatus(rs.getString("STATUS"));
		return formStatusDTO;
	}
	
	

}
