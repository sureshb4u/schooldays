package com.vernal.is.dto;


public class StudentDTO {
  
	private Integer id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private StandardDTO standard;
	private SectionDTO section;
	private String emailAddress;
	private YearDTO year;
	private GenderDTO gender;
	private Integer age;
	private String fatherName;
	private String dateOfJoining;
	private CommunityDTO community;
	private ReligionDTO religion;
	private BloodGroupDTO bloodGroup;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public StandardDTO getStandard() {
		return standard;
	}
	public void setStandard(StandardDTO standard) {
		this.standard = standard;
	}
	public SectionDTO getSection() {
		return section;
	}
	public void setSection(SectionDTO section) {
		this.section = section;
	}
	public YearDTO getYear() {
		return year;
	}
	public void setYear(YearDTO year) {
		this.year = year;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public CommunityDTO getCommunity() {
		return community;
	}
	public void setCommunity(CommunityDTO community) {
		this.community = community;
	}
	public ReligionDTO getReligion() {
		return religion;
	}
	public void setReligion(ReligionDTO religion) {
		this.religion = religion;
	}
	public BloodGroupDTO getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroupDTO bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public GenderDTO getGender() {
		return gender;
	}
	public void setGender(GenderDTO gender) {
		this.gender = gender;
	}

		
}
