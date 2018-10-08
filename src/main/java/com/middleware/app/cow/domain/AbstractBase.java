package com.middleware.app.cow.domain;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;

/**
 * <p>Class AbstractBase.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 25 ene 2017 ( Hora: 06:26:26 ).
 * @author jmchincho
 * Clase abstracta de la que heredan el resto de entidades.
 */
//@MappedSuperclass()
public abstract class AbstractBase implements Serializable {

    private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// CLAVE PRIMARIA DE LA ENTIDAD ( BASADO EN UN CAMPO SIMPLE )
	//----------------------------------------------------------------------
	final Long id;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(ES)
    //----------------------------------------------------------------------
    /**
	 * Constructor por defecto
	 */
	public AbstractBase() {
		this.id = 0L;
    }

    /**
	 * Constructor de la clase
	 */
    public AbstractBase(Long id) {
		this.id = id;
    }
    
	//----------------------------------------------------------------------
	// GETTER & SETTER PARA EL CAMPO CLAVE
	//----------------------------------------------------------------------
//    /**
//	 * @return Se devuelve el campo 'id'
//	 */
//	public Long getId() {
//        return id;
//    }

	public abstract Long getId();
	
//    /**
//	 * @param id El campo 'id' a establecer
//	 */
//	public void setId(Long id) {
//        this.id = id;
//    }

	abstract void setId(Long id);

	//----------------------------------------------------------------------
    // hashCode
    //----------------------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		AbstractBase other = (AbstractBase) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
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
		if (getId() != null) {
			builder.append("id=");
			builder.append(getId());
			builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
    }
}
