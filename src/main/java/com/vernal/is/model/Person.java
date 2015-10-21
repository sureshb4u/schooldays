/**
 * 
 */
package com.vernal.is.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author bashelu
 *
 */
public class Person {
	private Integer id;
	 
    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;
    
    private UUID orgId;

    private String type;

    private String contact;
    
    private String gender;
    
    private String _links;
    
    private String addresses;
    private String  emailAddresses;
   
    private List<Role> roles;
    
    private List<Asset> assets;
    
    private AccountLink accountLink;
    
    private List<Alias> alias;
    
    private String designation;

    private String bioGraphy;
    
    private Integer experience;
    
    private String dateOfJoining;
    
    private String fatherName;
    
   
	public String getBioGraphy() {
		return bioGraphy;
	}

	public void setBioGraphy(String bioGraphy) {
		this.bioGraphy = bioGraphy;
	}

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDateOfBirth() {
	    return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
	}

	public UUID getOrgId() {
		return orgId;
	}

	public void setOrgId(UUID orgId) {
		this.orgId = orgId;
	}
	
	public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String get_links() {
		return _links;
	}

	public void set_links(String _links) {
		this._links = _links;
	}

	
	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
 	/**
 	 * @return assets
 	 */
 	public List<Asset> getAssets() {
		return assets;
	}

	/**
	 * @param assets to set
	 */
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	
	/**
	 * @return the accountLink 
	 */
	public AccountLink getAccountLink() {
		return accountLink;
	}

	/**
	 * @param accountLink the accountLink to set
	 */
	public void setAccountLink(AccountLink accountLink) {
		this.accountLink = accountLink;
	}

	/**
	 * @return the alias
	 */
	public List<Alias> getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(List<Alias> alias) {
		this.alias = alias;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(String emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	
}