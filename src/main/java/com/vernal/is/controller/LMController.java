package com.vernal.is.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.backservice.LMService;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping(value= "/leaveManagement")
public class LMController {

	@Resource
	LMService lMService;
	/**
	 * 
	 * @param status
	 * @param session
	 * @return
	 */
	@RequestMapping(value= "/pending")
	@ResponseBody
	public List<LeaveManagementDTO> getPendingLMSList(HttpEntity<String> entity, HttpServletRequest request){
		List<LeaveManagementDTO> lmsList = null;
		try {
			String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
			String role = request.getHeader(CommonConstants.SESSION_USERROLE);
			if(userID != null && role != null){
				Integer userId = Integer.valueOf(userID);
				lmsList = lMService.getLMSList(CommonConstants.STATUS_PENDING, userId, role);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmsList;
	}
	
	
	@RequestMapping(value= "/history")
	@ResponseBody
	public Object getHistoryLMSList( HttpServletRequest request){
		List<LeaveManagementDTO> lmsList = null;
		try {
			String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
			String role = request.getHeader(CommonConstants.SESSION_USERROLE);
			if(userID != null && role != null){
				Integer userId = Integer.valueOf(userID);
				lmsList = lMService.getLMSList(CommonConstants.STATUS_PENDING, userId, role);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lmsList;
	}
	
	/**
	 * 
	 * @param leaveManagement
	 * @param session
	 * @return
	 */
	@RequestMapping(value = CommonConstants.CREATE_LEAVE_REQUEST)
	@ResponseBody
	public Object createLeaveRequest(@RequestBody LeaveManagementDTO leaveManagementListDTO,HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			if(leaveManagementListDTO != null ){
				String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
				String role = request.getHeader(CommonConstants.SESSION_USERROLE);
				if(userID != null && role != null){
					Integer userId = Integer.valueOf(userID);
					responseBean = lMService.Applyleave(leaveManagementListDTO,userId);
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  responseBean ;
	}
	

	/**
	 * 
	 * @param leaveManagement
	 * @param session
	 * @return
	 */
	@RequestMapping(value = CommonConstants.UPDATE_REQUEST)
	public Object updateStatusForLeaveRequest(@RequestBody List<LeaveManagementDTO> leaveManagementListDTO,HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			if(leaveManagementListDTO != null && !leaveManagementListDTO.isEmpty()){
				String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
				String role = request.getHeader(CommonConstants.SESSION_USERROLE);
				if(userID != null && role != null){
					Integer userId = Integer.valueOf(userID);
					responseBean = lMService.statusChange(leaveManagementListDTO, userId);
			}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return  responseBean ;
	}
	
	
}
