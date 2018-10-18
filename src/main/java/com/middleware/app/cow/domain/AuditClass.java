// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

//import es.dominion.ftw.util.convertidores.BooleanConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * <p>classAudit AuditoriaAuditClassEntity.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 22 jul 2016 ( Hora: 15:31:56 ).
 * @author Dominion digital
 * classAudit de persistencia para la entidad almacenada en la tabla "audit_classAudit"
 */
@Entity
@Table(name="audit_class" )
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="AuditClass.findAll", query="SELECT x FROM AuditClass x" ),
  @NamedQuery ( name="AuditClass.countAll", query="SELECT COUNT(x) FROM AuditClass x" )
} )
public class AuditClass extends AbstractBase implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_audit_classAudit")
	@SequenceGenerator(name = "cow_generator_audit_classAudit", sequenceName = "sq_audit_classAudit", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="audit", nullable=false, length=1)
    private String audit;

    @Column(name="classAudit", nullable=false, length=255)
    private String classAudit;

    @Column(name="service", length=255)
    private String service;



    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public AuditClass() {
		super();
    }

	/**
	 * Constructor de la superclassAudit
	 */
	public AuditClass(Long id) {
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
	 * @return Se devuelve el campo 'audit'
	 */
	public String getAudit() {
        return this.audit;
    }
	/**
	 * @param audit<String> - El campo 'audit' a establecer
	 */
	public void setAudit( String audit ) {
        this.audit = audit;
    }

	/**
	 * @return Se devuelve el campo 'classAudit'
	 */
	public String getClassAudit() {
        return this.classAudit;
    }
	/**
	 * @param classAudit<String> - El campo 'classAudit' a establecer
	 */
	public void setClassAudit( String classAudit ) {
        this.classAudit = classAudit;
    }

	/**
	 * @return Se devuelve el campo 'service'
	 */
	public String getService() {
        return this.service;
    }
	/**
	 * @param service<String> - El campo 'service' a establecer
	 */
	public void setService( String service ) {
        this.service = service;
    }



    /**
	 * Getters & Setters para las relaciones
	 */


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
    	result = prime * result + ((audit == null) ? 0 : audit.hashCode());
    	result = prime * result + ((classAudit == null) ? 0 : classAudit.hashCode());
    	result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		if (!(obj instanceof AuditClass)) {
			return false;
		}
		AuditClass other = (AuditClass) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (audit == null) {
			if (other.getAudit() != null) {
				return false;
			}
		} else if (!audit.equals(other.getAudit())) {
			return false;
		}
		if (classAudit == null) {
			if (other.getClassAudit() != null) {
				return false;
			}
		} else if (!classAudit.equals(other.getClassAudit())) {
			return false;
		}
		if (service == null) {
			if (other.getService() != null) {
				return false;
			}
		} else if (!service.equals(other.getService())) {
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
		if (audit != null) {
			builder.append("audit=");
			builder.append(audit);
			builder.append(", ");
		}		
		if (classAudit != null) {
			builder.append("classAudit=");
			builder.append(classAudit);
			builder.append(", ");
		}		
		if (service != null) {
			builder.append("service=");
			builder.append(service);
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

