package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;

public interface CommonDAO {

	public List<CommunityDTO> getCommunity();
	
	public List<ReligionDTO> getReligion();

    public List<DesignationDTO> getDesignation();

	public Integer getId(String entity, String type);

}
