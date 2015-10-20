package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.CommunityDTO;

public class CommunityRowMapper implements RowMapper<CommunityDTO>{

	@Override
	public CommunityDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs == null) {
			return null;
		}
		
		CommunityDTO communityDTO = new CommunityDTO();
		communityDTO.setId(rs.getInt("ID"));
		communityDTO.setName(rs.getString("NAME"));
		return communityDTO;
	}
}
