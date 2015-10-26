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
import com.vernal.is.mapper.LeaveManagementRowMapper;
import com.vernal.is.util.CommonConstants;

public class LeaveManagementImpl  extends NamedParameterJdbcDaoSupport implements LeaveDAO{

	@Override
	public List<LeaveManagementDTO> getLeaveByStatus(String status,Integer userId,String role) {
		List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
		String ID_STATUS = "SELECT ID FROM form_status where STATUS = ?";
		String LEAVE_FORM = "SELECT * FROM leave_management WHERE ID_FORM_STATUS =?";
				
		try{ 
			String[] statusInput= {status};
			Integer statusId=  getJdbcTemplate().queryForObject(
                    ID_STATUS, statusInput, Integer.class);
			
				
			if(role != CommonConstants.ROLE_ADMIN){
				LEAVE_FORM = LEAVE_FORM+" AND ID_STAFF =?";
				Integer[] inputs = {statusId,userId};
					leaveList = getJdbcTemplate().query(LEAVE_FORM,inputs, new LeaveManagementRowMapper());
			}else{
			Integer[] input = {statusId};
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
				if(leave.getStaff() != null && leave.getStaff().getId() != null){
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

				if(leave.getStaff() != null && leave.getStaff().getId() != null){
					INSERT_LEAVE = INSERT_LEAVE+ leave.getStaff().getId()+",";
				}
				if(leave.getStaff() != null){
					INSERT_LEAVE = INSERT_LEAVE+ leave.getStaff()+",";

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
				INSERT_LEAVE = INSERT_LEAVE+ CommonConstants.IS_DELETED+","+"NOW()"+","+accessId
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
						leave.setId(id.intValue());
						System.out.println("id ------------>"+id);
						if(id != null){
							responseBean.setStatus("SUCCESS");
							responseBean.setMessage("Leave Is applied");
						}
					}
					}
				}
					catch(Exception e){
						responseBean.setStatus("FAILED");
						responseBean.setMessage( e.getMessage());
					}
		        return responseBean;
				

}

	
	public  ResponseBean statusChange(List<LeaveManagementDTO> leaveDTO, Integer userId) {
		// TODO Auto-generated method stub
		ResponseBean responceBean = new ResponseBean();
		try{
		for(LeaveManagementDTO leave : leaveDTO){
		String UPDATE_LEAVE = "UPDATE `leave_management` SET"; 
		
		UPDATE_LEAVE = UPDATE_LEAVE+"`ID`="+leave.getId()+",";
		if(leave.getStaff() != null && leave.getStaff().getId() != null){
			UPDATE_LEAVE = UPDATE_LEAVE+"`ID_STAFF`="+leave.getStaff().getId()+",";
			}
			if(leave.getStartTime()!=null){
			    UPDATE_LEAVE = UPDATE_LEAVE+"`START_TIME`="+leave.getStartTime()+",";
			}
			if(leave.getEndTime() != null){
			    UPDATE_LEAVE = UPDATE_LEAVE+"`END_TIME`="+leave.getEndTime()+",";
			}
			if(leave.getReason() != null){
				UPDATE_LEAVE = UPDATE_LEAVE+"`REASON`="+leave.getReason()+",";
			}
			if(leave.getIsTaken() != null){
				UPDATE_LEAVE = UPDATE_LEAVE+"`IS_TAKEN`="+leave.getIsTaken()+",";
			}
			if(leave.getFormStatus() != null && leave.getFormStatus().getId()!=null){
				UPDATE_LEAVE = UPDATE_LEAVE+"`ID_FORM_STATUS`="+leave.getFormStatus().getId()+",";
			}
			UPDATE_LEAVE = UPDATE_LEAVE+"`UPDATED_BY`="+userId;	
			
			getJdbcTemplate().execute(UPDATE_LEAVE);
		}
		}catch(Exception e){
			responceBean.setStatus("FAILED");
			   String eStr = e.getMessage();
			   responceBean.setMessage(eStr);
		}
		return null;
	}
	}