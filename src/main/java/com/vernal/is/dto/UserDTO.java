package com.vernal.is.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * An User DTO 
 * User : Rubini
 * Date : 28/04/2015
 */
@JsonInclude(value=Include.NON_EMPTY)
public class UserDTO extends PersonDTO{

	private UUID orgPersonId;
	private UUID personId;
	private String userName;
	private DomainReferenceDTO status;
	private DomainReferenceDTO userNameType;
	private String userNameValue;
	private boolean isPrimary;
	private String secret;
	private String secretType;
	private UUID userId;
	//private OrganizationPerson orgPerson;
	//private AccountLinkDTO _links;
	private PersonDTO profile;
	private String sessionToken;
	
	private List<OrganizationRoleDTO> orgRoleDTOList;
	/**
	 * @return the orgRoleDTOList
	 */
	public List<OrganizationRoleDTO> getOrgRoleDTOList() {
		return orgRoleDTOList;
	}
	/**
	 * @param orgRoleDTOList the orgRoleDTOList to set
	 */
	public void setOrgRoleDTOList(List<OrganizationRoleDTO> orgRoleDTOList) {
		this.orgRoleDTOList = orgRoleDTOList;
	}
	public UUID getOrgPersonId() {
		return orgPersonId;
	}
	public void setOrgPersonId(UUID orgPersonId) {
		this.orgPersonId = orgPersonId;
	}
	public UUID getPersonId() {
		return personId;
	}
	public void setPersonId(UUID personId) {
		this.personId = personId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public DomainReferenceDTO getStatus() {
		return status;
	}
	public void setStatus(DomainReferenceDTO status) {
		this.status = status;
	}
	public DomainReferenceDTO getUserNameType() {
		return userNameType;
	}
	public void setUserNameType(DomainReferenceDTO userNameType) {
		this.userNameType = userNameType;
	}
	public String getUserNameValue() {
		return userNameValue;
	}
	public void setUserNameValue(String userNameValue) {
		this.userNameValue = userNameValue;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getSecretType() {
		return secretType;
	}
	public void setSecretType(String secretType) {
		this.secretType = secretType;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	/*public OrganizationPerson getOrgPerson() {
		return orgPerson;
	}
	public void setOrgPerson(OrganizationPerson orgPerson) {
		this.orgPerson = orgPerson;
	}*/
	public PersonDTO getProfile() {
		return profile;
	}
	public void setProfile(PersonDTO profile) {
		this.profile = profile;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	
}