package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vernal.is.dao.CommonDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.SectionDTO;
import com.vernal.is.dto.StandardDTO;

@Component
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

	public Integer getId(String entity, String type){
		return commonDAO.getId(entity, type);
	}

	public List<StandardDTO> getStandard() {
		// TODO Auto-generated method stub
		return commonDAO.getStandard();
	}

	public List<SectionDTO> getSection() {
		// TODO Auto-generated method stub
		return commonDAO.getSection();
	}
	
}
