/**
 * 
 */
package com.vernal.is.dto;

import java.util.UUID;

/**
 * @author bashelu
 *
 */
public class ParentDTO extends BaseDTO {
	
	private UUID entityId;
	private DomainReferenceDTO entityType;
	
	/**
	 * @return the entityId
	 */
	public UUID getEntityId() {
		return entityId;
	}
	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(UUID entityId) {
		this.entityId = entityId;
	}
	/**
	 * @return the entityType
	 */
	public DomainReferenceDTO getEntityType() {
		return entityType;
	}
	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(DomainReferenceDTO entityType) {
		this.entityType = entityType;
	}
}
