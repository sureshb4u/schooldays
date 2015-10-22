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
	
	public List<LeaveManagementDTO> getPendingLeave(String status,Integer userId, String role) {
		// TODO Auto-generated method stub
		return leaveDAO.getLeaveByStatus(status,userId,role);
	}
	

	public List<LeaveManagementDTO> statusChange(List<LeaveManagementDTO> leaveDTO) {
		// TODO Auto-generated method stub
		return leaveDAO.statusChange(leaveDTO);
	}
}
