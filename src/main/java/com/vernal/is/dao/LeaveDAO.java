package com.vernal.is.dao;

import java.util.List;

import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;

public interface LeaveDAO {


	public List<LeaveManagementDTO> getLeaveByStatus(String status,Integer userId,String accessId);

	public ResponseBean Applyleave(LeaveManagementDTO leave,Integer accessId,Integer staffId);

	public ResponseBean  statusChange(List<LeaveManagementDTO> leaveDTO, Integer accessId);
	
}
