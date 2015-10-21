package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import com.vernal.is.dao.CommonDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;

public class CommonService {
	@Resource
	CommonDAO commonDAO;
	
	public List<CommunityDTO> getCommunity() {
		// TODO Auto-generated method stub
		return commonDAO.getCommunity();
	}
	
	public List<ReligionDTO> getReligion() {
		// TODO Auto-generated method stub
		return commonDAO.getReligion();
	}
	
	public List<DesignationDTO> getDesignation() {
		// TODO Auto-generated method stub
		return commonDAO.getDesignation();
	}

}
