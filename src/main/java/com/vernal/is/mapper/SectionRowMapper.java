package com.vernal.is.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vernal.is.dto.SectionDTO;

public class SectionRowMapper implements RowMapper<SectionDTO>{

	@Override
	public SectionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		if(rs == null){
			return null;
		}
		SectionDTO sectionDTO = new SectionDTO();
		sectionDTO.setId(rs.getInt("ID"));
		sectionDTO.setName(rs.getString("NAME"));
		return sectionDTO;
	}

}
