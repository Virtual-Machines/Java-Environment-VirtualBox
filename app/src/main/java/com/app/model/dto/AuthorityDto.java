package com.app.model.dto;

/**
 * Authorities DTO (Data Transfer Object)
 * 
 * @author David García Prados
 *
 */
public class AuthorityDto {
	
	private Long autId;
	private RoleDto role;
	private UserDto user;

	public Long getAutId() {
		return autId;
	}

	public void setAutId(Long autId) {
		this.autId = autId;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthorityDto [autId=" + autId + ", role=" + role + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autId == null) ? 0 : autId.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		AuthorityDto other = (AuthorityDto) obj;
		if (autId == null) {
			if (other.autId != null)
				return false;
		} else if (!autId.equals(other.autId)) {
			return false;
		}
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role)) {
			return false;
		}
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}
