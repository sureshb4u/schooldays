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
	
	public List<LeaveManagementDTO> getLMSList(String status, Integer userId, String role) {
		// TODO Auto-generated method stub
		return leaveDAO.getLeaveByStatus(status, userId,role);
	}
	public ResponseBean applyleave(LeaveManagementDTO leaveDTO, Integer accessId, Integer staffId) {
		// TODO Auto-generated method stub
		return leaveDAO.Applyleave(leaveDTO, accessId, staffId);
	}
	
	 
	public ResponseBean statusChange(List<LeaveManagementDTO> leaveDTO, Integer accessId) {
		// TODO Auto-generated method stub
		return  leaveDAO.statusChange(leaveDTO,accessId);
	}
}
