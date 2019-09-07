package com.app.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.app.model.entity.generic.GenericEntity;

/**
 * The persistent class for the role database table.
 * 
 * @author David García Prados
 */
@Entity
@Table(name = "m_role")
public class RoleEntity extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private Long rolId;

	// rolCode is the natural id
	@NaturalId
	@Column(name = "rol_code", nullable = false, unique = true)
	private String rolCode;

	// bi-directional many-to-one association to Authority
	@OneToMany(mappedBy = "role", cascade = CascadeType.MERGE)
	private Set<AuthorityEntity> authorities;

	public RoleEntity() {
		super();
	}

	public RoleEntity(String rolCode) {
		super();
		this.rolCode = rolCode;
	}

	public Long getRolId() {
		return this.rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getRolCode() {
		return this.rolCode;
	}

	public void setRolCode(String rolCode) {
		this.rolCode = rolCode;
	}

	public Set<AuthorityEntity> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "RoleEntity [rolId=" + rolId + ", rolCode=" + rolCode + ", authorities=" + authorities + ", deleted="
				+ deleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rolCode == null) ? 0 : rolCode.hashCode());
		result = prime * result + ((rolId == null) ? 0 : rolId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleEntity other = (RoleEntity) obj;
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