package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.LeaveManagementDTO;

public interface LeaveDAO {


	public List<LeaveManagementDTO> getLeaveByStatus(String status,Integer userId,String accessId);

	public List<LeaveManagementDTO> statusChange(
			List<LeaveManagementDTO> leaveDTO);

	
	
	
	

}
