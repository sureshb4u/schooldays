/**
 * 
 */
package com.vernal.is.dto;

/**
 * @author bashelu
 *
 */
import java.util.UUID;

public class AliasDTO extends BaseDTO {

	private DomainReferenceDTO entityType;
	private DomainReferenceDTO aliasType;
	private String value;
	private UUID entityId;
	
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
	/**
	 * @return the aliasType
	 */
	public DomainReferenceDTO getAliasType() {
		return aliasType;
	}
	/**
	 * @param aliasType the aliasType to set
	 */
	public void setAliasType(DomainReferenceDTO aliasType) {
		this.aliasType = aliasType;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
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
}

