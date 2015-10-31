package com.vernal.is.view.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vernal.is.model.LeaveManagement;
import com.vernal.is.model.User;
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
	@RequestMapping(value = CommonConstants.CREATE_LEAVE_REQUEST ,method = RequestMethod.POST)
	public ResponseEntity<?> createLeaveRequest(@RequestBody LeaveManagement leaveManagement, HttpSession session){
		Object obj = null;
		try {
			System.out.println(gson.toJson(leaveManagement));
		//	obj = lMSService.createLMSRequest(leaveManagement, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
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
