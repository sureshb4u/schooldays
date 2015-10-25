package com.vernal.is.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.backservice.LMSService;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.model.LeaveManagement;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping(value= "/leaveManagement")
public class LMController {

	@Resource
	LMSService lMSService;
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
				lmsList = lMSService.getLMSList(CommonConstants.STATUS_PENDING, userId, role);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmsList;
	}
	
	
	@RequestMapping(value= "/history")
	@ResponseBody
	public Object getHistoryLMSList(HttpEntity<String> entity, HttpSession session){
		List<LeaveManagement> lmsList = null;
		try {
		//	lmsList = lMSService.getLMSByStatus(CommonConstants.STATUS_HISTORY, session);
		} catch (Exception e) {
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
	public Object createLeaveRequest(@RequestBody LeaveManagementDTO leaveManagementDTO, HttpSession session){
		Object obj = null;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  obj ;
	}
	
	

	/**
	 * 
	 * @param leaveManagement
	 * @param session
	 * @return
	 */
	@RequestMapping(value = CommonConstants.UPDATE_REQUEST)
	public Object updateStatusForLeaveRequest(@RequestBody List<LeaveManagementDTO> leaveManagementListDTO, HttpSession session){
		Object obj = null;
		try {
			if(leaveManagementListDTO != null && !leaveManagementListDTO.isEmpty()){
			//	obj = lMSService.updateLMS(leaveManagementList, session);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return  obj ;
	}
	
	
}
