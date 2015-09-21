/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
public class AddressDTO extends BaseDTO{
	
	private String line1;
	private String line2;
	private DomainReferenceDTO country;
	private DomainReferenceDTO state;
	private String city;
	private DomainReferenceDTO type;
	private String zipcode;
	
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public DomainReferenceDTO getCountry() {
		return country;
	}
	public void setCountry(DomainReferenceDTO country) {
		this.country = country;
	}
	public DomainReferenceDTO getState() {
		return state;
	}
	public void setState(DomainReferenceDTO state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public DomainReferenceDTO getType() {
		return type;
	}
	public void setType(DomainReferenceDTO type) {
		this.type = type;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
