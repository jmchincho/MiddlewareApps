package com.middleware.app.cow.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * <p>Class AbstractManaged.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 22 jul 2016 ( Hora: 14:16:04 ).
 * @author Dominion digital
 * Clase abstracta de la que heredan el resto de entidades
 */
@MappedSuperclass()
public abstract class AbstractManaged extends AbstractBase implements Serializable {

	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// deleted
	//----------------------------------------------------------------------
	@Column(name="deleted", nullable=false)
    private boolean deleted;


	//----------------------------------------------------------------------
	// CONSTRUCTOR(ES)
	//----------------------------------------------------------------------
	/**
	 * Constructor por defecto
	 */
	public AbstractManaged() {
		
	}

	/**
	 * Constructor de la superclase
	 */
    public AbstractManaged(Long id) {
		super(id);
	}

	/**
	 * Constructor de la clase
	 */
    public AbstractManaged(Long id, Boolean deleted) {
		super(id);
		this.deleted = deleted;
	}
    
	//----------------------------------------------------------------------
	// GETTER & SETTER PARA EL CAMPO DESCRIPCION
	//----------------------------------------------------------------------
	/**
	 * @return Se devuelve el campo 'deleted'
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted El campo 'deleted' a establecer
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
    
	//----------------------------------------------------------------------
	// hashCode
	//----------------------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// Id del abstract ------------------------------------------------------------------
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		// ----------------------------------------------------------------------------------
		return result;
	}

	//----------------------------------------------------------------------
	// equals
	//----------------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractManaged other = (AbstractManaged) obj;
		// Id del abstract ------------------------------------------------------------------
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		// ----------------------------------------------------------------------------------
		return true;
	}

	//----------------------------------------------------------------------
	// toString
	//----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" [");
		// Id del abstract ------------------------------------------------------------------
		builder.append(" [");
		if (getId() != null) {
			builder.append("id=");
			builder.append(getId());
			builder.append(", ");
		}
		// ----------------------------------------------------------------------------------
		builder.append("deleted=");
		builder.append(deleted);
		builder.append(", ");
		builder.append("]");

		return builder.toString();
	}
}
