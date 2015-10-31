package com.vernal.is.dto;



public class LeaveManagementDTO extends BaseDTO {
   private Integer id;
   private UserDTO staff;
   private String startTime;
   private String endTime;
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
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
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
