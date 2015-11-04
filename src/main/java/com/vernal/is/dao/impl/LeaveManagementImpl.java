package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
import com.vernal.is.util.CommonUtil;

public class LeaveManagementImpl  extends NamedParameterJdbcDaoSupport implements LeaveDAO{


	
	@Resource 
	CommonUtil commonUtil;
	@Override
	public List<LeaveManagementDTO> getLeaveByStatus(String status,Integer userId,String role) {
		List<LeaveManagementDTO> leaveList = new ArrayList<LeaveManagementDTO>();
		String ID_STATUS = "SELECT ID FROM status where STATUS = ? ";
		String LEAVE_FORM = "SELECT * FROM leave_management L "
				+ "LEFT JOIN status S ON L.ID_FORM_STATUS = S.ID "
				+ "LEFT JOIN user U ON L.ID_STAFF = U.ID";
				
				
		try{ 
			if(status.equalsIgnoreCase(CommonConstants.STATUS_PENDING)){
			String[] statusInput= {status};
			Integer statusId =  getJdbcTemplate().queryForObject(
	                    ID_STATUS, statusInput, Integer.class);
			System.out.println( "STATUS ID"+ statusId);
				LEAVE_FORM = LEAVE_FORM+ " WHERE L.ID_FORM_STATUS = ? ";
			
				
			if(!role.equals(CommonConstants.ROLE_ADMIN)){
				LEAVE_FORM = LEAVE_FORM+" AND ID_STAFF = ?";
				Integer[] inputs = {statusId,userId};
					leaveList = getJdbcTemplate().query(LEAVE_FORM,inputs, new LeaveManagementRowMapper());
			}
			else{
			Integer[] input = {statusId};
			leaveList = getJdbcTemplate().query(LEAVE_FORM,input, new LeaveManagementRowMapper());

			}
			}else{
				String[] statusInput= {CommonConstants.STATUS_PENDING};
				Integer statusId =  getJdbcTemplate().queryForObject(
		                    ID_STATUS, statusInput, Integer.class);
				System.out.println( "STATUS ID"+ statusId);
					LEAVE_FORM = LEAVE_FORM+ " WHERE L.ID_FORM_STATUS <> ? ";
				
					
				if(!role.equals(CommonConstants.ROLE_ADMIN)){
					LEAVE_FORM = LEAVE_FORM+" AND ID_STAFF = ?";
					Integer[] inputs = {statusId,userId};
						leaveList = getJdbcTemplate().query(LEAVE_FORM,inputs, new LeaveManagementRowMapper());
				}
				else{
				Integer[] input = {statusId};
				leaveList = getJdbcTemplate().query(LEAVE_FORM,input, new LeaveManagementRowMapper());

				}
			}
			
		}
			catch (Exception e){
				e.printStackTrace();
				   String eStr = e.getMessage();
			}
			
			return leaveList;
		}
		


	public ResponseBean Applyleave(LeaveManagementDTO leave,Integer accessId,Integer staffId) {
		ResponseBean responseBean= new ResponseBean(); 
		try{
		String INSERT_LEAVE = "INSERT INTO `leave_management`(";
		
				INSERT_LEAVE = INSERT_LEAVE+"`ID_STAFF`,";
				
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
					INSERT_LEAVE = INSERT_LEAVE+ staffId+",";
					if(leave.getStartTime()!=null){
						INSERT_LEAVE = INSERT_LEAVE+ commonUtil.stringFeilds(leave.getStartTime())+",";
					}
					if(leave.getEndTime() != null){
						INSERT_LEAVE = INSERT_LEAVE+ commonUtil.stringFeilds(leave.getEndTime())+",";
					}
					if(leave.getReason() != null){
						INSERT_LEAVE = INSERT_LEAVE+ commonUtil.stringFeilds(leave.getReason())+",";
					}
					if(leave.getIsTaken() != null){
						INSERT_LEAVE = INSERT_LEAVE+ leave.getIsTaken()+",";
					}
					if(leave.getFormStatus() != null ){
						String ID_STATUS = "SELECT ID FROM status where STATUS = "+commonUtil.stringFeilds(leave.getFormStatus().getStatus());
						Integer statusId=  getJdbcTemplate().queryForObject(
			                    ID_STATUS,Integer.class);
					INSERT_LEAVE = INSERT_LEAVE+ statusId+",";
					}
				INSERT_LEAVE = INSERT_LEAVE+ CommonConstants.IS_DELETED +" ,"+" NOW() "+" , "+accessId
				+" )";
				
					System.out.println("query>>>>"+INSERT_LEAVE);
				
						  // KeyHolder keyHolder = new GeneratedKeyHolder();
						getJdbcTemplate().update(INSERT_LEAVE );
						/*Number id = keyHolder.getKey();
						leave.setId(id.intValue());
						System.out.println("id leave------------>"+id);
						if(id != null){*/
							responseBean.setStatus("SUCCESS");
							responseBean.setMessage("Leave Is applied");
						
				}
					catch(Exception e){
						e.printStackTrace();
						responseBean.setStatus("FAILED");
						responseBean.setMessage( e.getMessage());
					}
		        return responseBean;
				

}

	
	public  ResponseBean statusChange(List<LeaveManagementDTO> leaveDTO,Integer accessId) {
		// TODO Auto-generated method stub
		ResponseBean responceBean = new ResponseBean();
		try{
		for(LeaveManagementDTO leave : leaveDTO){
		String UPDATE_LEAVE = "UPDATE `leave_management` SET"; 
		
		
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
			if(leave.getFormStatus() != null){
				String ID_STATUS = "SELECT ID FROM status where STATUS = "+commonUtil.stringFeilds(leave.getFormStatus().getStatus());
				Integer statusId=  getJdbcTemplate().queryForObject(
	                    ID_STATUS,Integer.class);
				UPDATE_LEAVE = UPDATE_LEAVE+"`ID_FORM_STATUS`= "+statusId+ ",";
			}
			UPDATE_LEAVE = UPDATE_LEAVE+"`UPDATED_BY`="+accessId;	
			UPDATE_LEAVE = UPDATE_LEAVE+ " WHERE ID = "+leave.getId();
			getJdbcTemplate().execute(UPDATE_LEAVE);
		}
		responceBean.setStatus("SUCCESS");
		responceBean.setMessage("Your Leave Form is updated successfully");
		
		}catch(Exception e){
			responceBean.setStatus("FAILED");
			   String eStr = e.getMessage();
			   responceBean.setMessage(eStr);
		}
		return responceBean;
	}



	}