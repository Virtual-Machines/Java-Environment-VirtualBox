package com.app.model.entity;

import java.util.HashSet;
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
 * The persistent class for the users database table
 * 
 * @author David García Prados
 * 
 */
@Entity
@Table(name = "m_user")
public class UserEntity extends GenericEntity {

	private static final long serialVersionUID = 1L;

	public static final String USR_USERNAME_FIELD = "usrUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long usrId;

	@Column(name = "usr_enabled")
	private Boolean usrEnabled;

	@Column(name = "usr_password")
	private String usrPassword;

	// username is the natural id
	@NaturalId
	@Column(name = "usr_username", nullable = false, unique = true)
	private String usrUsername;

	// bi-directional many-to-one association to Authority
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private Set<AuthorityEntity> authorities;

	public UserEntity() {
		super();
	}

	public UserEntity(Boolean usrEnabled, String usrPassword, String usrUsername) {
		super();
		this.usrEnabled = usrEnabled;
		this.usrPassword = usrPassword;
		this.usrUsername = usrUsername;
		this.authorities = new HashSet<>();
	}

	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public Boolean getUsrEnabled() {
		return this.usrEnabled;
	}

	public void setUsrEnabled(Boolean usrEnabled) {
		this.usrEnabled = usrEnabled;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public String getUsrUsername() {
		return this.usrUsername;
	}

	public void setUsrUsername(String usrUsername) {
		this.usrUsername = usrUsername;
	}

	public Set<AuthorityEntity> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}

	public AuthorityEntity addAuthority(AuthorityEntity authority) {
		getAuthorities().add(authority);
		return authority;
	}

	public AuthorityEntity removeAuthority(AuthorityEntity authority) {
		getAuthorities().remove(authority);
		authority.setUser(null);

		return authority;
	}

	@Override
	public String toString() {
		return "UserEntity [usrId=" + usrId + ", usrEnabled=" + usrEnabled + ", usrPassword=" + usrPassword
				+ ", usrUsername=" + usrUsername + ", authorities=" + authorities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((usrId == null) ? 0 : usrId.hashCode());
		result = prime * result + ((usrUsername == null) ? 0 : usrUsername.hashCode());
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
		UserEntity other = (UserEntity) obj;
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