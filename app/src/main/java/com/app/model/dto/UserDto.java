
package com.app.model.dto;

import java.util.Set;
import java.util.StringJoiner;

import com.app.constant.MessageConstants;
import com.app.util.MessageUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User DTO (Data Transfer Object)
 * 
 * @author David García Prados
 *
 */

public class UserDto {

	public static final String USR_USERNAME_FIELD = "usrUsername";

	private Long usrId;

	private Boolean usrEnabled;

	@JsonIgnore
	private String usrPassword;

	private String usrUsername;

	@JsonIgnore
	private Set<AuthorityDto> authorities;

	/**
	 * Get if user is Enabled with text
	 * 
	 * @return String
	 */
	public String getUsrActive() {
		return usrEnabled ? MessageUtils.getMessage(MessageConstants.TEXT_YES)
				: MessageUtils.getMessage(MessageConstants.TEXT_NO);
	}

	/**
	 * Get all codes of roles separated by commas
	 * 
	 * @return String
	 */
	public String getUsrRolesByComma() {
		StringJoiner result = new StringJoiner(",");
		for (AuthorityDto aut : authorities) {
			result.add(aut.getRole().getRolCode());
		}
		return result.toString();
	}

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

	public Set<AuthorityDto> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityDto> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserDto [usrId=" + usrId + ", usrEnabled=" + usrEnabled + ", usrPassword=" + usrPassword
				+ ", usrUsername=" + usrUsername + ", authorities=" + authorities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usrId == null) ? 0 : usrId.hashCode());
		result = prime * result + ((usrUsername == null) ? 0 : usrUsername.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (usrId == null) {
			if (other.usrId != null)
				return false;
		} else if (!usrId.equals(other.usrId)) {
			return false;
		}
		if (usrUsername == null) {
			if (other.usrUsername != null)
				return false;
		} else if (!usrUsername.equals(other.usrUsername)) {
			return false;
		}
		return true;
	}

}
