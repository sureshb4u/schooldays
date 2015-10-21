package com.vernal.is.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vernal.is.serializers.JsonDateSerializer;

@JsonInclude(value=Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends BaseDTO {

	private Integer id;
	
    private String firstName;

    private String lastName;

    private String fatherName;

    private Date dateOfBirth;
    
    private CommunityDTO community;
    
    private ReligionDTO religion;
    
    private GenderDTO gender;
    
    private Integer age;
    
    private List<StaffAddressDTO> addresses;
    
    private String  emailAddresses;
    
    private DesignationDTO  designation;
    
    private String  bioGraphy;
    
    private Integer experience;
    
    private  Date   dateOfJoining; 
   
    private List<StaffPhoneNumberDTO> phoneNumbers;

    private UserRoleDTO roles;

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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GenderDTO getGender() {
		return gender;
	}

	public void setGender(GenderDTO gender) {
		this.gender = gender;
	}

	public DesignationDTO getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationDTO designation) {
		this.designation = designation;
	}

	public String getBioGraphy() {
		return bioGraphy;
	}

	public void setBioGraphy(String bioGraphy) {
		this.bioGraphy = bioGraphy;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
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


	public List<StaffAddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StaffAddressDTO> addresses) {
		this.addresses = addresses;
	}

	public String getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(String emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public List<StaffPhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<StaffPhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public UserRoleDTO getRoles() {
		return roles;
	}

	public void setRoles(UserRoleDTO roles) {
		this.roles = roles;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}