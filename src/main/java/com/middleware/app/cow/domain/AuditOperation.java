// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Class AuditOperation.java.</p>
 * <b>Project:</b><p>Farmatools Web</p>
 * @version 1.0, 22 jul 2016 ( Hora: 15:31:56 ).
 * @author Dominion digital
 * Clase de persistencia para la entity almacenada en la tabla "auditoria_op"
 */
@Entity
@Table(name="audit_operation" )
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="AuditOperation.findAll", query="SELECT x FROM AuditOperation x" ),
  @NamedQuery ( name="AuditOperation.countAll", query="SELECT COUNT(x) FROM AuditOperation x" )
} )
public class AuditOperation extends AbstractBase implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entity  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_audit_operation")
	@SequenceGenerator(name = "cow_generator_audit_operation", sequenceName = "sq_auditoria_op", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entity  
	 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false)
    private Date date;

    @Column(name="type_audit", nullable=false, length=1)
    private String type;

    @Column(name="device", length=255)
    private String device;

    @Column(name="entity", length=255)
    private String entity;

    @Lob
    @Column(name="parameters")
    private String parameters;

    @Lob
    @Column(name="txtsql")
    private String txtSql;



    /**
	 * Enlaces con otras entityes (Relaciones) 
	 */
	@JsonIgnore
    @OneToMany(mappedBy="auditOperation", targetEntity=AuditResult.class)
    private List<AuditResult> auditsResults;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="User_id", referencedColumnName="id")
    private User User;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public AuditOperation() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public AuditOperation(Long id) {
		super(id);
	}

    
	
	/**
	 * Getters & Setters para la clave primaria de la entity 
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
	 * @return Se devuelve el campo 'date'
	 */
	public Date getDate() {
        return this.date;
    }
	/**
	 * @param date<Date> - El campo 'date' a establecer
	 */
	public void setDate( Date date ) {
        this.date = date;
    }

	/**
	 * @return Se devuelve el campo 'type'
	 */
	public String getType() {
        return this.type;
    }
	/**
	 * @param type<String> - El campo 'type' a establecer
	 */
	public void setType( String type ) {
        this.type = type;
    }

	/**
	 * @return Se devuelve el campo 'device'
	 */
	public String getDevice() {
        return this.device;
    }
	/**
	 * @param device<String> - El campo 'device' a establecer
	 */
	public void setDevice( String device ) {
        this.device = device;
    }

	/**
	 * @return Se devuelve el campo 'entity'
	 */
	public String getEntity() {
        return this.entity;
    }
	/**
	 * @param entity<String> - El campo 'entity' a establecer
	 */
	public void setEntity( String entity ) {
        this.entity = entity;
    }

	/**
	 * @return Se devuelve el campo 'parameters'
	 */
	public String getParameters() {
        return this.parameters;
    }
	/**
	 * @param parameters<String> - El campo 'parameters' a establecer
	 */
	public void setParameters( String parameters ) {
        this.parameters = parameters;
    }

	/**
	 * @return Se devuelve el campo 'txtSql'
	 */
	public String getTxtSql() {
        return this.txtSql;
    }
	/**
	 * @param txtSql<String> - El campo 'txtSql' a establecer
	 */
	public void setTxtSql( String txtSql ) {
        this.txtSql = txtSql;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de type 'List<AuditResult>'
	 */
	public List<AuditResult> getAuditsResults() {
        return this.auditsResults;
    }
	/**
	 * @param auditsResults<List<AuditResultEntity>> - La lista de objetos de type 'List<AuditResult>' a establecer
	 */
	public void setAuditResults( List<AuditResult> auditsResults ) {
        this.auditsResults = auditsResults;
    }

	/**
	 * @return Se devuelve la lista de objetos de type 'User'
	 */
	public User getUser() {
        return this.User;
    }
	/**
	 * @param User<User> - La lista de objetos de type 'User' a establecer
	 */
	public void setUser( User User ) {
        this.User = User;
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
    	result = prime * result + ((date == null) ? 0 : date.hashCode());
    	result = prime * result + ((type == null) ? 0 : type.hashCode());
    	result = prime * result + ((device == null) ? 0 : device.hashCode());
    	result = prime * result + ((entity == null) ? 0 : entity.hashCode());
    	result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
    	result = prime * result + ((txtSql == null) ? 0 : txtSql.hashCode());
		result = prime * result + ((User == null) ? 0 : User.hashCode());
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
		if (!(obj instanceof AuditOperation)) {
			return false;
		}
		AuditOperation other = (AuditOperation) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (device == null) {
			if (other.device != null) {
				return false;
			}
		} else if (!device.equals(other.device)) {
			return false;
		}
		if (entity == null) {
			if (other.entity != null) {
				return false;
			}
		} else if (!entity.equals(other.entity)) {
			return false;
		}
		if (parameters == null) {
			if (other.parameters != null) {
				return false;
			}
		} else if (!parameters.equals(other.parameters)) {
			return false;
		}
		if (txtSql == null) {
			if (other.txtSql != null) {
				return false;
			}
		} else if (!txtSql.equals(other.txtSql)) {
			return false;
		}
		if (!(auditsResults instanceof List)) {
			if (!(other.auditsResults instanceof List)) {
				if (auditsResults == null) {
					if (other.auditsResults != null) {
						return false;
					}
				} else if (!auditsResults.equals(other.auditsResults)) {
					return false;
				}
			}			
		} else if (other.auditsResults != null && !(other.auditsResults instanceof List)) {
			return false;
		}
		if (User == null) {
			if (other.User != null) {
				return false;
			}
		} else if (!User.equals(other.User)) {
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
		if (date != null) {
			builder.append("date=");
			builder.append(date);
			builder.append(", ");
		}		
		if (type != null) {
			builder.append("type=");
			builder.append(type);
			builder.append(", ");
		}		
		if (device != null) {
			builder.append("device=");
			builder.append(device);
			builder.append(", ");
		}		
		if (entity != null) {
			builder.append("entity=");
			builder.append(entity);
			builder.append(", ");
		}		
		if (parameters != null) {
			builder.append("parameters=");
			builder.append(parameters);
			builder.append(", ");
		}		
		if (txtSql != null) {
			builder.append("txtSql=");
			builder.append(txtSql);
			builder.append(", ");
		}		
		if (auditsResults != null && !(auditsResults instanceof List)) {
			builder.append("auditsResults=");
			builder.append(toString(auditsResults, maxLen));
			builder.append(", ");
		}		
		if (User != null) {
			builder.append("User=");
			builder.append(User);
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

