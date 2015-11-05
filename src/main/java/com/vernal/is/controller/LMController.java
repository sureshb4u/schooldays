package com.vernal.is.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vernal.is.backservice.LMService;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.util.CommonConstants;
import com.vernal.is.view.controller.BaseController;

@Controller
@RequestMapping(value= "/leaveManagement")
public class LMController extends BaseController {

	@Resource
	LMService lMService;
	/**
	 * 
	 * @param status
	 * @param session
	 * @return
	 */
	@RequestMapping(value= "/PENDING", method = RequestMethod.GET)
	@ResponseBody
	public List<LeaveManagementDTO> getPendingLMSList(HttpEntity<String> entity, HttpServletRequest request){
		List<LeaveManagementDTO> lmsList = null;
		try {
			String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
			String role = request.getHeader(CommonConstants.SESSION_USERROLE);
			System.out.println("roleee"+ role);
			if(userID != null && role != null){
				Integer userId = Integer.valueOf(userID);
				lmsList = lMService.getLMSList(CommonConstants.STATUS_PENDING, userId, role);
				System.out.println(gson.toJson(lmsList));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmsList;
	}
	
	
	@RequestMapping(value= "/HISTORY", method = RequestMethod.GET)
	@ResponseBody
	public Object getHistoryLMSList( HttpServletRequest request){
		List<LeaveManagementDTO> lmsList = null;
		try {
			String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
			String role = request.getHeader(CommonConstants.SESSION_USERROLE);
			if(userID != null && role != null){
				Integer userId = Integer.valueOf(userID);
				lmsList = lMService.getLMSList(CommonConstants.STATUS_HISTORY, userId, role);
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
	@RequestMapping(value = "/{staffId}"+CommonConstants.CREATE_LEAVE_REQUEST, method = RequestMethod.POST)
	@ResponseBody
	public Object createLeaveRequest(@PathVariable(value = "staffId") String staffID,
			@RequestBody LeaveManagementDTO leaveDTO, HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			if(leaveDTO != null ){
				Integer staffId = Integer.valueOf(staffID);
				Integer accessId = Integer.valueOf(request.getHeader(CommonConstants.SESSION_USER_ID));
				if(staffId != null && accessId != null){
					responseBean = lMService.applyleave(leaveDTO, accessId, staffId);
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
	@RequestMapping(value = CommonConstants.UPDATE_REQUEST, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean updateStatusForLeaveRequest(@RequestBody List<LeaveManagementDTO> leaveManagementListDTO,HttpServletRequest request){
		ResponseBean responseBean = new ResponseBean();
		try {
			if(leaveManagementListDTO != null && !leaveManagementListDTO.isEmpty()){
				String userID = request.getHeader(CommonConstants.SESSION_USER_ID);
				String role = request.getHeader(CommonConstants.SESSION_USERROLE);
				if(userID != null && role != null){
					Integer userId = Integer.valueOf(userID);
					responseBean = lMService.statusChange(leaveManagementListDTO, userId);
					System.out.println("responseBean--------->"+responseBean);
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return  responseBean ;
	}
	
	
}
