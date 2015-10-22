package com.vernal.is.view.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vernal.is.model.LeaveManagement;
import com.vernal.is.service.LMSService;
import com.vernal.is.util.CommonConstants;

@Controller
@RequestMapping(value= "/lms")
public class LMSController extends BaseController{

	@Resource
	LMSService lMSService; 
	
	
	/**
	 * 
	 * @param status
	 * @param session
	 * @return
	 */
	@RequestMapping(value= "/{status}/list")
	public Object getLMSList(@PathVariable(value="status")String status, HttpSession session){
		List<LeaveManagement> lmsList = null;
		try {
		if(status != null &&!status.isEmpty()){
				lmsList = lMSService.getLMSByStatus(status, session);
		}
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
	public Object createLeaveRequest(@RequestBody LeaveManagement leaveManagement, HttpSession session){
		Object obj = null;
		try {
			obj = lMSService.createLMSRequest(leaveManagement, session);
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
	public Object updateStatusForLeaveRequest(@RequestBody List<LeaveManagement> leaveManagementList, HttpSession session){
		Object obj = null;
		try {
			if(leaveManagementList != null && !leaveManagementList.isEmpty()){
				obj = lMSService.updateLMS(leaveManagementList, session);
			}
		} catch (ParseException e) {
				e.printStackTrace();
		}
		return  obj ;
	}
	
	
}
