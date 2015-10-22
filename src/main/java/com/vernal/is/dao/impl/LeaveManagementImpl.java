package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vernal.is.dao.LeaveDAO;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.mapper.CommunityRowMapper;
import com.vernal.is.mapper.LeaveManagementRowMapper;
import com.vernal.is.mapper.UserListRowMapper;
import com.vernal.is.util.CommonConstants;

public class LeaveManagementImpl  extends NamedParameterJdbcDaoSupport implements LeaveDAO{

	@Override
	public List<LeaveManagementDTO> getLeaveByStatus(String status,Integer userId,String role) {
		List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
		String ID_STATUS = "SELECT ID FROM form_status where STATUS = "+status;
		String LEAVE_FORM = "SELECT * FROM leave_management WHERE ID_FORM_STATUS =?";
				
		try{ 
			String[] statusInput= {status};
			Integer statusId=  getJdbcTemplate().queryForObject(
                    ID_STATUS,statusInput,Integer.class);
			Integer[] input = {statusId};
			
			
			if(role != CommonConstants.ROLE_ADMIN){
				LEAVE_FORM = LEAVE_FORM+" AND ID_STAFF ="+userId;;
			}
			if(statusId != null){
				leaveList = getJdbcTemplate().query(LEAVE_FORM,input, new LeaveManagementRowMapper());
			}
			
			}
			catch (Exception e){
				   String eStr = e.getMessage();
			}
			
			return leaveList;
		}
		


	public ResponseBean Applyleave(LeaveManagementDTO leave,Integer accessId) {
		ResponseBean responseBean= new ResponseBean(); 
		String ID_STATUS = "SELECT ID FROM form_status where STATUS =? ";
		String INSERT_LEAVE = "INSERT INTO `leave_management`(";
				if(leave.getIdStaff() != null){
				INSERT_LEAVE = INSERT_LEAVE+"`ID_STAFF`,";
				}
				if(leave.getStartTime()!=null){
					INSERT_LEAVE = INSERT_LEAVE+ " `START_TIME`,";
				}
				if(leave.getEndTime() != null){
					INSERT_LEAVE = INSERT_LEAVE+" `END_TIME`, ";
				}
				if(leave.getReason() != null){
					INSERT_LEAVE = INSERT_LEAVE+ "`REASON`,";
				}
				if(leave.getIsTaken() != null){
					INSERT_LEAVE = INSERT_LEAVE+ " `IS_TAKEN`, ";
				}
				if(leave.getFormStatus() != null ){
				INSERT_LEAVE = INSERT_LEAVE+ " `ID_FORM_STATUS`, ";
				}
				INSERT_LEAVE = INSERT_LEAVE+ "`IS_DELETED`,"
				+ "`CREATED_ON`,"
				+ " `CREATED_BY`) "
				+ "VALUES (";
				if(leave.getIdStaff() != null){
					INSERT_LEAVE = INSERT_LEAVE+ leave.getIdStaff()+",";
					
					}
					if(leave.getStartTime()!=null){
						INSERT_LEAVE = INSERT_LEAVE+ leave.getStartTime()+",";
					}
					if(leave.getEndTime() != null){
						INSERT_LEAVE = INSERT_LEAVE+ leave.getEndTime()+",";
					}
					if(leave.getReason() != null){
						INSERT_LEAVE = INSERT_LEAVE+ leave.getReason()+",";
					}
					if(leave.getIsTaken() != null){
						INSERT_LEAVE = INSERT_LEAVE+ leave.getIsTaken()+",";
					}
					if(leave.getFormStatus() != null ){
					INSERT_LEAVE = INSERT_LEAVE+"?,";
					}
				INSERT_LEAVE = INSERT_LEAVE+ "0,NOW(),"+accessId
				+")";
				try{
					if(leave.getFormStatus() != null && leave.getFormStatus().getStatus()!= null){
					String[] statusInput= {leave.getFormStatus().getStatus()};
					Integer statusId=  getJdbcTemplate().queryForObject(
		                    ID_STATUS,statusInput,Integer.class);
					if(statusId!= null)
					{
						   KeyHolder keyHolder = new GeneratedKeyHolder();
						   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
								   leave);
						if(leave != null)
						getNamedParameterJdbcTemplate().update(INSERT_LEAVE, namedParameters, keyHolder );
						Number id = keyHolder.getKey();
						System.out.println("id ------------>"+id);
						if(id != null){
							responseBean.setStatus("SUCCESS");
							responseBean.setMessage("The new user is added successfully");
						}
					}
					catch(Exception e){
						
					}
		return null;


				}





	@Override
	public List<LeaveManagementDTO> statusChange(
			List<LeaveManagementDTO> leaveDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	}