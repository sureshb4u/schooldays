package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.LeaveManagementDTO;

public interface LeaveDAO {

	public List<LeaveManagementDTO> getPendingLeave();

	public List<LeaveManagementDTO> getPendingLeaveById();

	public List<LeaveManagementDTO> getHistory();

	public List<LeaveManagementDTO> getHistoryById();

	public List<LeaveManagementDTO> statusChange();
	
	
	
	

}
