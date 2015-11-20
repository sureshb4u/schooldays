package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;

public interface LeaveDAO {


	public List<LeaveManagementDTO> getPendingLeave(String status,Integer userId,String role);
	public List<LeaveManagementDTO> getHistoryLeave(String status,Integer userId,String role);

	public ResponseBean Applyleave(LeaveManagementDTO leave,Integer accessId);

	public ResponseBean  statusChange(List<LeaveManagementDTO> leaveDTO, Integer userId);
	
}
