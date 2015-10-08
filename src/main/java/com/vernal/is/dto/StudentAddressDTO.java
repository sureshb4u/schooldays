package com.vernal.is.dto;

public class StudentAddressDTO {

	private Integer id;
	private Integer idStudent;
	private StudentDTO student;
	private String address;
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
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
