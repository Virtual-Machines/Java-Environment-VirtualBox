package com.app.model.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User Form
 * 
 * @author David García Prados
 *
 */
public class UserForm {

	private Long usrId;

	@NotNull
	private Boolean usrEnabled;

	@NotNull
	@Size(min = 8, max = 100)
	private String usrPassword;

	@NotNull
	@Size(min = 3, max = 50)
	private String usrUsername;

	public Long getUsrId() {
		return usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public Boolean getUsrEnabled() {
		return usrEnabled;
	}

	public void setUsrEnabled(Boolean usrEnabled) {
		this.usrEnabled = usrEnabled;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public String getUsrUsername() {
		return usrUsername;
	}

	public void setUsrUsername(String usrUsername) {
		this.usrUsername = usrUsername;
	}
}
