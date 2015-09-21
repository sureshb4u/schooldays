/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
public class AccountLinkDTO {

	private String addresses;
	private String phones;
	private String emailAddresses;
	private String assets;
	private String locations;
	
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(String emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public String getAssets() {
		return assets;
	}
	public void setAssets(String assets) {
		this.assets = assets;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
}
