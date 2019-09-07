package com.app.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Role DTO (Data Transfer Object)
 * 
 * @author David García Prados
 *
 */
public class RoleDto {

	public static final String ROL_CODE_FIELD = "rolCode";

	private Long rolId;
	private String rolCode;
	
	@JsonIgnore
	private Set<AuthorityDto> authorities;

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getRolCode() {
		return rolCode;
	}

	public void setRolCode(String rolCode) {
		this.rolCode = rolCode;
	}

	public Set<AuthorityDto> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityDto> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "RoleDto [rolId=" + rolId + ", rolCode=" + rolCode + ", authorities=" + authorities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rolCode == null) ? 0 : rolCode.hashCode());
		result = prime * result + ((rolId == null) ? 0 : rolId.hashCode());
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
		RoleDto other = (RoleDto) obj;
		if (rolCode == null) {
			if (other.rolCode != null)
				return false;
		} else if (!rolCode.equals(other.rolCode)) {
			return false;
		}
		if (rolId == null) {
			if (other.rolId != null)
				return false;
		} else if (!rolId.equals(other.rolId)) {
			return false;
		}
		return true;
	}

}
