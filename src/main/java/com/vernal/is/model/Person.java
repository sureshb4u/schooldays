/**
 * 
 */
package com.vernal.is.model;

import java.util.List;
import java.util.UUID;

/**
 * @author bashelu
 *
 */
public class Person {

	private UUID id;
	 
    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;
    
    private UUID orgId;

    private String type;

    private String gender;
    
    private String _links;
    
    private List<Address> addresses;
    
    private List<EmailAddress> emailAddresses;
   
    private List<PhoneNumber> phoneNumbers;
    
    private List<Role> roles;
    
    private List<Asset> assets;
    
    private AccountLink accountLink;
    
    private List<Alias> alias;
    
    private String designation;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the emailAddresses
	 */
	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * @param emailAddresses the emailAddresses to set
	 */
	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/**
	 * @return the phoneNumbers
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
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
	
	
}