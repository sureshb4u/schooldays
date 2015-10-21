package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.vernal.is.dao.LeaveDAO;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.mapper.CommunityRowMapper;
import com.vernal.is.mapper.LeaveManagementRowMapper;

public class LeaveManagementImpl  extends NamedParameterJdbcDaoSupport implements LeaveDAO{

	@Override
	public List<LeaveManagementDTO> getPendingLeave() {
		List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
		String PENDING = "SELECT * FROM leave_management where ID_FORM_STATUS = 1";
		try{ 
			leaveList =  getJdbcTemplate().query(
					PENDING,new LeaveManagementRowMapper());
			}
			catch (Exception e){
				   String eStr = e.getMessage();
			}
			
			return leaveList;
		}
		
	

	@Override
	public List<LeaveManagementDTO> getPendingLeaveById() {
		List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
		String PENDING_BY_ID = "SELECT * FROM leave_management where ID_FORM_STATUS = ? AND ID_STAFF = ?";
		try{
			leaveList =  getJdbcTemplate().query(PENDING_BY_ID,new LeaveManagementRowMapper());
			}
			catch (Exception e){
				   String eStr = e.getMessage();
			}
			
			return leaveList;
		}
	@Override
	public List<LeaveManagementDTO> getHistory() {
		// TODO Auto-generated method stub
			List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
			String HISTORY = "SELECT * FROM leave_management where ID_FORM_STATUS in (?)";
			try{
				leaveList =  getJdbcTemplate().query(HISTORY,new LeaveManagementRowMapper());
				}
				catch (Exception e){
					   String eStr = e.getMessage();
				}
				
				return leaveList;
			}

	@Override
	public List<LeaveManagementDTO> getHistoryById() {
		// TODO Auto-generated method stub
			List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
			String HISTORY_BY_ID = "SELECT * FROM leave_management where ID_FORM_STATUS = ? AND ID_STAFF = ?";
			try{
				leaveList =  getJdbcTemplate().query(HISTORY_BY_ID,new LeaveManagementRowMapper());
				}
				catch (Exception e){
					   String eStr = e.getMessage();
				}
				
				return leaveList;
			}

	@Override
	public List<LeaveManagementDTO> statusChange() {
		
		return null;
	}

}