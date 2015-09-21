package com.vernal.is.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Organization address DTO
 * User : Suganyadevi
 * Date : 12/09/2013
 */
@JsonInclude(value=Include.NON_EMPTY)
public class OrganizationAddressDTO extends AddressDTO {

	
}
