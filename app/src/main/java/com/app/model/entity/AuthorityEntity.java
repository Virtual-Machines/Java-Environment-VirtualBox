package com.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.model.entity.generic.GenericEntity;

/**
 * The persistent class for the authorities database table.
 * 
 * @author David García Prados
 * 
 */
@Entity
@Table(name = "t_authority")
public class AuthorityEntity extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aut_id")
	private Long autId;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "aut_role")
	private RoleEntity role;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "aut_user")
	private UserEntity user;

	public AuthorityEntity() {
		super();
	}

	public AuthorityEntity(RoleEntity role, UserEntity user) {
		super();
		this.role = role;
		this.user = user;
	}

	public Long getAutId() {
		return this.autId;
	}

	public void setAutId(Long autId) {
		this.autId = autId;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthorityEntity [autId=" + autId + ", role=" + role + ", user=" + user + ", deleted=" + deleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autId == null) ? 0 : autId.hashCode());
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
		AuthorityEntity other = (AuthorityEntity) obj;
		if (autId == null) {
			if (other.autId != null)
				return false;
		} else if (!autId.equals(other.autId)) {
			return false;
		}
		return true;
	}

}