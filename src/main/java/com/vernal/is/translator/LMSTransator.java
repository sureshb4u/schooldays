package com.vernal.is.translator;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.vernal.is.dto.LeaveManagementDTO;
import com.vernal.is.model.LeaveManagement;
import com.vernal.is.util.CommonConstants;

@Component
public class LMSTransator extends BaseTranslator{

	/**
	 * 
	 * @param object
	 * @return
	 */
	public List<LeaveManagementDTO> convertToListOfLMSDTO(Object object){
		Type listType = new TypeToken<List<LeaveManagementDTO>>() {}.getType();
		List<LeaveManagementDTO> leaveManagementDTOList = gson.fromJson(translateObjectToJson(object), listType);
		return leaveManagementDTOList;
	}

	/**
	 * 
	 * @param leaveManagementDTOList
	 * @return
	 */
	public List<LeaveManagement> translateToLMSList(List<LeaveManagementDTO> leaveManagementDTOList) {
		List<LeaveManagement> lmsList = new ArrayList<LeaveManagement>();
		if(leaveManagementDTOList != null && !leaveManagementDTOList.isEmpty()){
			for(LeaveManagementDTO leaveManagementDTO : leaveManagementDTOList){
				lmsList.add(translateToLMS(leaveManagementDTO));
			}
		}
		return lmsList;
	}

	/**
	 * 
	 * @param leaveManagementDTO
	 * @return
	 */

	public LeaveManagement translateToLMS(LeaveManagementDTO leaveManagementDTO) {
		LeaveManagement leaveManagement = null;
		if(leaveManagementDTO != null){
			leaveManagement = new LeaveManagement();
			if(leaveManagementDTO.getId()!= null){
				leaveManagement.setId(leaveManagementDTO.getId());
			}
			if(leaveManagementDTO.getStartTime() != null){
			//	leaveManagement.setFrom(commonUtil.formatTimeStampToDateString(leaveManagementDTO.getStartTime(), CommonConstants.DATE_DD_MMMM_YYYY));
			}
			if(leaveManagementDTO.getEndTime() != null){
			//	leaveManagement.setTo(commonUtil.formatTimeStampToDateString(leaveManagementDTO.getEndTime(), CommonConstants.DATE_DD_MMMM_YYYY));
			}
			if(leaveManagementDTO.getReason() != null){
				leaveManagement.setReason(leaveManagementDTO.getReason());
			}
		}
		return leaveManagement;
	}

	public LeaveManagementDTO translateToLMSDTO(LeaveManagement leaveManagement) throws ParseException {
		LeaveManagementDTO leaveManagementDTO = null ;
		if(leaveManagement != null){
			leaveManagementDTO = new LeaveManagementDTO();
			
			if(leaveManagement.getId() != null){
				leaveManagementDTO.setId(leaveManagement.getId());
			}
			
			if(leaveManagement.getFrom() != null && leaveManagement.getFromTime() != null){
				leaveManagementDTO.setStartTime(commonUtil.formatgivenStringToDate(leaveManagement.getFrom(), CommonConstants.DATE_DD_MMMM_YYYY, CommonConstants.DATE_TIME_FORMAT)+" "+timeFormatter(leaveManagement.getFromTime()));
			}
			
			if(leaveManagement.getTo() != null && leaveManagement.getToTime() != null){
				leaveManagementDTO.setEndTime(commonUtil.formatgivenStringToDate(leaveManagement.getTo(), CommonConstants.DATE_DD_MMMM_YYYY, CommonConstants.DATE_TIME_FORMAT)+" "+timeFormatter(leaveManagement.getToTime()));
			}
			
			if(leaveManagement.getReason() != null && !leaveManagement.getReason().isEmpty()){
				leaveManagementDTO.setReason(leaveManagement.getReason());
			}
			
		}
		return leaveManagementDTO;
	}

	/**
	 * 
	 * @param leaveManagementList
	 * @return
	 * @throws ParseException
	 */
	public List<LeaveManagementDTO> translateToLMSDTOList(List<LeaveManagement> leaveManagementList) throws ParseException {
		List<LeaveManagementDTO> leaveManagementDTOList = null;
		if(leaveManagementList != null){
			leaveManagementDTOList = new ArrayList<LeaveManagementDTO>();
			for(LeaveManagement leaveManagement: leaveManagementList){
				leaveManagementDTOList.add(translateToLMSDTO(leaveManagement));
			}
		}
		return leaveManagementDTOList;
	}
	
	public String timeFormatter(String time) throws ParseException{
		 SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
		 SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
	     Date date = parseFormat.parse(time);
		return displayFormat.format(date);
	}
}
