package com.vernal.is.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vernal.is.serializers.JsonDateSerializer;

/**
 * An Organization DTO 
 * User : Vernalis
 * Date : 20/08/2015
 */
@JsonInclude(value=Include.NON_EMPTY)
public class OrganizationDTO extends BaseDTO{
	
	private String mnemonic;
	private String orgName;
	private DomainReferenceDTO orgType;
	private List<OrganizationAddressDTO> addresses;
	private List<OrganizationEmailAddressDTO> emailAddresses;
	private List<OrganizationPhoneDTO> phones;
	private AccountLinkDTO _links;
	private List<RelatedOrganizationDTO> relationshipType;
	private List<DomainReferenceDTO> relationships = new ArrayList<DomainReferenceDTO>();
	private long personsCount;
	private boolean activeInTestCase;
	private List<AssetDTO> assets;
	private UUID relatedOrgId;
	
	public List<DomainReferenceDTO> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<DomainReferenceDTO> relationships) {
		this.relationships = relationships;
	}
	
	public void addRelationships(DomainReferenceDTO relationships) {
		this.relationships.add(relationships);
	}

	public long getPersonsCount() {
		return personsCount;
	}

	public void setPersonsCount(long personsCount) {
		this.personsCount = personsCount;
	}

	private Date lastTestDate; 
	
	@JsonSerialize(using=JsonDateSerializer.class)
    @JsonInclude(value=Include.NON_EMPTY)
	public void setLastTestDate(Date lastTestDate) {
		this.lastTestDate = lastTestDate;
	}
	
	public Date getLastTestDate() {
		return lastTestDate;
	}
	private List<PersonDTO> persons;
	
	
	public String getMnemonic() {
		return mnemonic;
	}
	
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
	
	public String getOrgName() {
		return orgName;
	}
	
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public DomainReferenceDTO getOrgType() {
		return orgType;
	}
	
	public void setOrgType(DomainReferenceDTO orgType) {
		this.orgType = orgType;
	}
	
	public List<OrganizationAddressDTO> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<OrganizationAddressDTO> addresses) {
		this.addresses = addresses;
	}
	
	public List<OrganizationEmailAddressDTO> getEmailAddresses() {
		return emailAddresses;
	}
	
	public void setEmailAddresses(List<OrganizationEmailAddressDTO> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public List<OrganizationPhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<OrganizationPhoneDTO> phones) {
		this.phones = phones;
	}

	public AccountLinkDTO get_links() {
		return _links;
	}
	
	public void set_links(AccountLinkDTO _links) {
		this._links = _links;
	}

	/**
	 * @return the relationshipType
	 */
	public List<RelatedOrganizationDTO> getRelationshipType() {
		return relationshipType;
	}

	/**
	 * @param relationshipType the relationshipType to set
	 */
	public void setRelationshipType(List<RelatedOrganizationDTO> relationshipType) {
		this.relationshipType = relationshipType;
	}

	/**
	 * @return the persons
	 */
	public List<PersonDTO> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(List<PersonDTO> persons) {
		this.persons = persons;
	}

	/**
	 * @return the activeInTestCase
	 */
	public boolean isActiveInTestCase() {
		return activeInTestCase;
	}

	/**
	 * @param activeInTestCase the activeInTestCase to set
	 */
	public void setActiveInTestCase(boolean activeInTestCase) {
		this.activeInTestCase = activeInTestCase;
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
	 * @return the relatedOrgId
	 */
	public UUID getRelatedOrgId() {
		return relatedOrgId;
	}

	/**
	 * @param relatedOrgId the relatedOrgId to set
	 */
	public void setRelatedOrgId(UUID relatedOrgId) {
		this.relatedOrgId = relatedOrgId;
	}
}