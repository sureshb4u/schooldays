package com.vernal.is.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
* Parent DTO
* User : Suganyadevi.P
* Date : 05/18/2015
*/
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO{
	private UUID id;
	private PersonDTO createdBy;
	private Date createdOn;
	private PersonDTO updatedBy;
	private Date updatedOn;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public PersonDTO getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(PersonDTO createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public PersonDTO getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(PersonDTO updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}