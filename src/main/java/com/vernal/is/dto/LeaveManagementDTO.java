package com.vernal.is.dto;

import java.sql.Timestamp;

public class LeaveManagementDTO extends BaseDTO {
   private Integer id;
   private UserDTO staff;
   private Timestamp startTime;
   private Timestamp endTime;
   private String reason;
   private Integer isTaken;
   private FormStatusDTO formStatus;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public UserDTO getStaff() {
	return staff;
}
public void setStaff(UserDTO staff) {
	this.staff = staff;
}
public Timestamp getStartTime() {
	return startTime;
}
public void setStartTime(Timestamp startTime) {
	this.startTime = startTime;
}
public Timestamp getEndTime() {
	return endTime;
}
public void setEndTime(Timestamp endTime) {
	this.endTime = endTime;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public Integer getIsTaken() {
	return isTaken;
}
public void setIsTaken(Integer isTaken) {
	this.isTaken = isTaken;
}
public FormStatusDTO getFormStatus() {
	return formStatus;
}
public void setFormStatus(FormStatusDTO formStatus) {
	this.formStatus = formStatus;
}


}
