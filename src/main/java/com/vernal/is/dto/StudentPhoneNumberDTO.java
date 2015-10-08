package com.vernal.is.dto;

public class StudentPhoneNumberDTO {
  private Integer id;
  private Integer idStudent;
  private Long phoneNumber;
  private Integer isPrimary;
  private Integer idStudentRelation;
  private StudentRelationDTO studentRelation;
  
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getIdStudent() {
	return idStudent;
}
public void setIdStudent(Integer idStudent) {
	this.idStudent = idStudent;
}
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Integer getIsPrimary() {
	return isPrimary;
}
public void setIsPrimary(Integer isPrimary) {
	this.isPrimary = isPrimary;
}
public Integer getIdStudentRelation() {
	return idStudentRelation;
}
public void setIdStudentRelation(Integer idStudentRelation) {
	this.idStudentRelation = idStudentRelation;
}
public StudentRelationDTO getStudentRelation() {
	return studentRelation;
}
public void setStudentRelation(StudentRelationDTO studentRelation) {
	this.studentRelation = studentRelation;
}


  
}
