package com.vernal.is.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.backservice.CommonService;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.ReligionDTO;
import com.vernal.is.dto.SectionDTO;
import com.vernal.is.dto.StandardDTO;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping(value=CommonConstants.COMMON_BASE_URL)
public class CommonBaseController {
	
	@Resource
	CommonService commonServic;
	
	@RequestMapping(value= "/"+ CommonConstants.COMMUNITY)
	@ResponseBody
	public List<CommunityDTO> getCommunityList(){
		return commonServic.getCommunity();
	}

	@RequestMapping(value= "/"+ CommonConstants.DESIGNATION)
	@ResponseBody
	public List<DesignationDTO> getDesignationList(){
		return commonServic.getDesignation();
	}
	
	@RequestMapping(value= "/"+ CommonConstants.RELIGION)
	@ResponseBody
	public List<ReligionDTO> getReligionList(){
		return commonServic.getReligion();
	}
	@RequestMapping(value= "/"+ CommonConstants.STANDARD_URL)
	@ResponseBody
	public List<StandardDTO> getStandardList(){
		return commonServic.getStandard();
	}
	@RequestMapping(value= "/"+ CommonConstants.SECTION_URL)
	@ResponseBody
	public List<SectionDTO> getSectionList(){
		return commonServic.getSection();
	}
}
