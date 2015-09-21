/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
public class PhoneNumberDTO  extends BaseDTO{

	private String phoneNumber;
	private DomainReferenceDTO type;
	private DomainReferenceDTO  status;
	private Boolean isPrimary;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public DomainReferenceDTO getType() {
		return type;
	}
	public void setType(DomainReferenceDTO type) {
		this.type = type;
	}
	public DomainReferenceDTO getStatus() {
		return status;
	}
	public void setStatus(DomainReferenceDTO status) {
		this.status = status;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}
