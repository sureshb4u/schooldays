package com.vernal.is.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A RelatedOrganizationDTO 
 * User: Amutha 
 * Date: 20/5/15
 */
@JsonInclude(value=Include.NON_EMPTY) 
public class RelatedOrganizationDTO extends BaseDTO{
	
	private String startOrganizationId;
	private String endOrganizationId;
	private DomainReferenceDTO relationshipType;
	private boolean status;
	private Date startDate;
	private String startOrganizationName;	
	
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the startOrganizationId
	 */
	public String getStartOrganizationId() {
		return startOrganizationId;
	}
	/**
	 * @param startOrganizationId the startOrganizationId to set
	 */
	public void setStartOrganizationId(String startOrganizationId) {
		this.startOrganizationId = startOrganizationId;
	}
	/**
	 * @return the endOrganizationId
	 */
	public String getEndOrganizationId() {
		return endOrganizationId;
	}
	/**
	 * @param endOrganizationId the endOrganizationId to set
	 */
	public void setEndOrganizationId(String endOrganizationId) {
		this.endOrganizationId = endOrganizationId;
	}
	/**
	 * @return the relationshipType
	 */
	public DomainReferenceDTO getRelationshipType() {
		return relationshipType;
	}
	/**
	 * @param relationshipType the relationshipType to set
	 */
	public void setRelationshipType(DomainReferenceDTO relationshipType) {
		this.relationshipType = relationshipType;
	}
	/**
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the startOrganizationName
	 */
	public String getStartOrganizationName() {
		return startOrganizationName;
	}
	/**
	 * @param startOrganizationName the startOrganizationName to set
	 */
	public void setStartOrganizationName(String startOrganizationName) {
		this.startOrganizationName = startOrganizationName;
	}
	
}
