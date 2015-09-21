/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
public class EmailAddressDTO extends BaseDTO{

	private String emailAddress;
	private DomainReferenceDTO type;
	private DomainReferenceDTO  status;
	private boolean isPrimary;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}
