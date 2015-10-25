package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.vernal.is.dao.CommonDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.mapper.CommunityRowMapper;
import com.vernal.is.mapper.DesignationRowMapper;
import com.vernal.is.mapper.ReligionRowMapper;
import com.vernal.is.util.CommonUtil;

public class CommonDAOImpl  extends NamedParameterJdbcDaoSupport implements CommonDAO {

	@Resource
	CommonUtil commonUtil;
	
	@Override
	public List<CommunityDTO> getCommunity() {
		List<CommunityDTO> communityList = new ArrayList<CommunityDTO>();
		String communities = "SELECT * FROM community";
		try{
		  communityList =  getJdbcTemplate().query(
				  communities,new CommunityRowMapper());
		}
		catch (Exception e){
			   String eStr = e.getMessage();
		}
		
		return communityList;
	}


	public List<ReligionDTO> getReligion() {
		List<ReligionDTO> religionList = new ArrayList<ReligionDTO>();
		String religion = "SELECT * FROM religion";
		try{
		  religionList =  getJdbcTemplate().query(
				  religion,new ReligionRowMapper());
		}
		catch (Exception e){
			   String eStr = e.getMessage();
		}
		
		return religionList;
	}
	@Override
	public List<DesignationDTO> getDesignation() {
		List<DesignationDTO> designationList = new ArrayList<DesignationDTO>();
		String designations = "SELECT * FROM designation";
		try{
			designationList =  getJdbcTemplate().query(
					designations,new DesignationRowMapper());
		return null;
		}
		catch (Exception e){
			   String eStr = e.getMessage();
			   
		}
		
		return designationList;
	}


	@Override
	public Integer getId(String entity, String type) {
	 String GET_ID = "SELECT ID FROM "+type+" WHERE "+type+" = "+ commonUtil.stringFeilds(entity);
	 Integer id = getJdbcTemplate().queryForObject(
				GET_ID,Integer.class); 
	return id;
	}


	
}
