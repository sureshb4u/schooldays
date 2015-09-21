package com.vernal.is.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {

	private UUID id;
	
    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;
    
    private UUID orgId;

    private DomainReferenceDTO type;

    private DomainReferenceDTO gender;
    
    private List<PersonAddressDTO> addresses;
    
    private List<PersonEmailAddressDTO> emailAddresses;
   
    private List<PersonPhoneDTO> phoneNumbers;

    private List<RoleDTO> roles;
    
	//private RoleDTO role;
    
    private List<AssetDTO> assets;
    
    private AccountLinkDTO _links;
    
    private List<AliasDTO> alias;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the orgId
	 */
	public UUID getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(UUID orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the type
	 */
	public DomainReferenceDTO getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(DomainReferenceDTO type) {
		this.type = type;
	}

	/**
	 * @return the gender
	 */
	public DomainReferenceDTO getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(DomainReferenceDTO gender) {
		this.gender = gender;
	}

	/**
	 * @return the addresses
	 */
	public List<PersonAddressDTO> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<PersonAddressDTO> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the emailAddresses
	 */
	public List<PersonEmailAddressDTO> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * @param emailAddresses the emailAddresses to set
	 */
	public void setEmailAddresses(List<PersonEmailAddressDTO> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/**
	 * @return the phoneNumbers
	 */
	public List<PersonPhoneDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<PersonPhoneDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the assets
	 */
	public List<AssetDTO> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<AssetDTO> assets) {
		this.assets = assets;
	}

	/**
	 * @return the _links
	 */
	public AccountLinkDTO get_links() {
		return _links;
	}

	/**
	 * @param _links the _links to set
	 */
	public void set_links(AccountLinkDTO _links) {
		this._links = _links;
	}

	/**
	 * @return the roles
	 */
	public List<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	/**
	 * @return the alias
	 */
	public List<AliasDTO> getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(List<AliasDTO> alias) {
		this.alias = alias;
	}
     
	
}