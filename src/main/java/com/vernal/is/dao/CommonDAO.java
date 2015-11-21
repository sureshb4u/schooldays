package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.SectionDTO;
import com.vernal.is.dto.StandardDTO;

public interface CommonDAO {

	public List<CommunityDTO> getCommunity();
	
	public List<ReligionDTO> getReligion();

    public List<DesignationDTO> getDesignation();

	public Integer getId(String entity, String type);

	public List<StandardDTO> getStandard();

	public List<SectionDTO> getSection();

}
