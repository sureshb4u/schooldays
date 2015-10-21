package com.vernal.is.backservice;

import java.util.List;

import javax.annotation.Resource;

import com.vernal.is.dao.LeaveDAO;
import com.vernal.is.dto.CommunityDTO;
import com.vernal.is.dto.DesignationDTO;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ReligionDTO;

public class LeaveManagementService {
	@Resource
      LeaveDAO leaveDAO;
	
	public List<LeaveManagementDTO> getPendingLeave() {
		// TODO Auto-generated method stub
		return leaveDAO.getPendingLeave();
	}
	
	public List<LeaveManagementDTO> getPendingLeaveById() {
		// TODO Auto-generated method stub
		return leaveDAO.getPendingLeaveById();
	}
	
	public List<LeaveManagementDTO> getHistory() {
		// TODO Auto-generated method stub
		return leaveDAO.getHistory();
	}
	public List<LeaveManagementDTO> getHistoryById() {
		// TODO Auto-generated method stub
		return leaveDAO.getHistoryById();
	}
   
	public List<LeaveManagementDTO> statusChange() {
		// TODO Auto-generated method stub
		return leaveDAO.statusChange();
	}
}
