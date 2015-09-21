package com.vernal.is.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * User : Rubini
 * Date : 30/04/2015
 * Description: RoleService is used to Manage the Role Details
 */
@JsonInclude(value=Include.NON_EMPTY)
public class RoleDTO extends BaseDTO{

	private DomainReferenceDTO name;
	
	private List<DomainReferenceDTO> privileges;

	/**
	 * @return the privileges
	 */
	public List<DomainReferenceDTO> getPrivileges() {
		return privileges;
	}
	
	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(List<DomainReferenceDTO> privileges) {
		this.privileges = privileges;
	}

	public DomainReferenceDTO getName() {
		return name;
	}

	public void setName(DomainReferenceDTO name) {
		this.name = name;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

}