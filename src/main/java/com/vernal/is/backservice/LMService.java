package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vernal.is.dao.LeaveDAO;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;
@Component
public class LMService {
	@Resource
      LeaveDAO leaveDAO;
	
	
	public List<LeaveManagementDTO> getPendingLeave(String status,Integer userId, String role) {
		// TODO Auto-generated method stub
		return leaveDAO.getPendingLeave(status, userId,role);
	}
	
	public List<LeaveManagementDTO> getHistoryLeave(String status,Integer userId, String role) {
		// TODO Auto-generated method stub
		return leaveDAO.getHistoryLeave(status, userId,role);
	}
	
	public ResponseBean Applyleave(LeaveManagementDTO leaveDTO, Integer userId) {
		// TODO Auto-generated method stub
		return leaveDAO.Applyleave(leaveDTO,userId);
	}
	
	 
	public ResponseBean statusChange(List<LeaveManagementDTO> leaveDTO, Integer userId) {
		// TODO Auto-generated method stub
		return  leaveDAO.statusChange(leaveDTO,userId);
	}
}
