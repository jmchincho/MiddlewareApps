// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

//import es.dominion.ftw.util.convertidores.BooleanConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * <p>Class AuditResult.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 22 jul 2016 ( Hora: 15:31:56 ).
 * @author Dominion digital
 * Clase de persistencia para la entidad almacenada en la tabla "auditoria_res"
 */
@Entity
@Table(name="audit_result" )
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="AuditResult.findAll", query="SELECT x FROM AuditResult x" ),
  @NamedQuery ( name="AuditResult.countAll", query="SELECT COUNT(x) FROM AuditResult x" )
} )
public class AuditResult extends AbstractBase implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7573481602767457984L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_audit_result")
	@SequenceGenerator(name = "cow_generator_audit_result", sequenceName = "sq_auditoria_res", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Lob
    @Column(name="value_finish")
    private String valueFinish;

    @Lob
    @Column(name="value_start")
    private String valueStart;



    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="audit_operation_id", referencedColumnName="id")
    private AuditOperation auditOperation;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public AuditResult() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public AuditResult(Long id) {
		super(id);
	}

    
	
	/**
	 * Getters & Setters para la clave primaria de la entidad 
	 */
	/**
	 * @return Se devuelve el campo 'id'
	 */
	public Long getId() {
        return this.id;
    }

    /**
	 * @param id El campo 'id' a establecer
	 */
	public void setId(Long id) {
		this.id=id;
    }


    /**
	 * Getters & Setters para los campos
	 */
	/**
	 * @return Se devuelve el campo 'valueFinish'
	 */
	public String getValueFinish() {
        return this.valueFinish;
    }
	/**
	 * @param valueFinish<String> - El campo 'valueFinish' a establecer
	 */
	public void setValueFinish( String valueFinish ) {
        this.valueFinish = valueFinish;
    }

	/**
	 * @return Se devuelve el campo 'valueStart'
	 */
	public String getValueStart() {
        return this.valueStart;
    }
	/**
	 * @param valueStart<String> - El campo 'valueStart' a establecer
	 */
	public void setValueStart( String valueStart ) {
        this.valueStart = valueStart;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'auditOperationEntity'
	 */
	public AuditOperation getAuditOperation() {
        return this.auditOperation;
    }
	/**
	 * @param auditOperation<auditOperationEntity> - La lista de objetos de tipo 'auditOperationEntity' a establecer
	 */
	public void setAuditOperation( AuditOperation auditOperation ) {
        this.auditOperation = auditOperation;
    }



    //----------------------------------------------------------------------
    // hashCode
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Objec#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    	result = prime * result + ((valueFinish == null) ? 0 : valueFinish.hashCode());
    	result = prime * result + ((valueStart == null) ? 0 : valueStart.hashCode());
		result = prime * result + ((auditOperation == null) ? 0 : auditOperation.hashCode());
		return result;
	}

	

    //----------------------------------------------------------------------
    // equals
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof AuditResult)) {
			return false;
		}
		AuditResult other = (AuditResult) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (valueFinish == null) {
			if (other.valueFinish != null) {
				return false;
			}
		} else if (!valueFinish.equals(other.valueFinish)) {
			return false;
		}
		if (valueStart == null) {
			if (other.valueStart != null) {
				return false;
			}
		} else if (!valueStart.equals(other.valueStart)) {
			return false;
		}
		if (auditOperation == null) {
			if (other.auditOperation != null) {
				return false;
			}
		} else if (!auditOperation.equals(other.auditOperation)) {
			return false;
		}

		return true;
	}


    //----------------------------------------------------------------------
    // toString
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" [");
		if (getId() != null) {
			builder.append("id=");
			builder.append(getId());
			builder.append(", ");
		}
		if (valueFinish != null) {
			builder.append("valueFinish=");
			builder.append(valueFinish);
			builder.append(", ");
		}		
		if (valueStart != null) {
			builder.append("valueStart=");
			builder.append(valueStart);
			builder.append(", ");
		}		
		if (auditOperation != null) {
			builder.append("auditOperation=");
			builder.append(auditOperation);
			builder.append(", ");
		}		
		builder.append("]");

		return builder.toString();
    }

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0) {
				builder.append(", ");
			}
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
}

