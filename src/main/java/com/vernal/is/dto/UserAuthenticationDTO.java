package com.vernal.is.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * An UserAuthendticationDTO
 * User : Somasundarapandi.S
 * Date : 19/05/2015
 */
@JsonInclude(value=Include.NON_EMPTY)
public class UserAuthenticationDTO{

	private String userName;
	private String userSecret;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSecret() {
		return userSecret;
	}
	public void setUserSecret(String userSecret) {
		this.userSecret = userSecret;
	}
	
}