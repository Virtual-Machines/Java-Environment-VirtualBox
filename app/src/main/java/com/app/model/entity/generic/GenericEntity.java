package com.app.model.entity.generic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Generic Entity
 * 
 * @author David García Prados
 *
 */

@MappedSuperclass
public class GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String DELETED_FIELD = "deleted";

	// Deleted attribute (default: false)
	@Column(name = DELETED_FIELD)
	protected Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "GenericEntity [deleted=" + deleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
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
		GenericEntity other = (GenericEntity) obj;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted)) {
			return false;
		}
		return true;
	}

}
