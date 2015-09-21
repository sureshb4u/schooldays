package com.vernal.is.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(value=Include.NON_EMPTY)
public class OrganizationPhoneDTO extends PhoneNumberDTO {

	
}
