// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Class Comments.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:21 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Comments"
 */
@Entity
@Table(name="Comments")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Comments.findAll", query="SELECT x FROM Comments x" ),
  @NamedQuery ( name="Comments.countAll", query="SELECT COUNT(x) FROM Comments x" )
} )
public class Comments extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_CommentsEntity")
	@SequenceGenerator(name = "cow_generator_CommentsEntity", sequenceName = "sq_Comments", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="description", nullable=false, length=500)
    private String description;

    @Column(name="name", nullable=false, length=255)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;

    @Column(name="approved", nullable=false, length=1)
    private String approved;

    @Column(name="score", nullable=false)
    private Integer score;

    @Column(name="denounced", nullable=false, length=1)
    private String denounced;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customers_id", referencedColumnName="id")
    private Customers customers;
	
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="items_id", referencedColumnName="id")
    private Items items;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Comments() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Comments(Long id) {
		super(id, false);
	}

    
	
	/**
	 * Getters & Setters para la clave primaria de la entidad 
	 */
	/**
	 * @return Se devuelve el campo 'id'
	 */
	@Override
	public Long getId() {
        return this.id;
    }

    /**
	 * @param id El campo 'id' a establecer
	 */
	@Override
	public void setId(Long id) {
		this.id=id;
    }


    /**
	 * Getters & Setters para los campos
	 */
	/**
	 * @return Se devuelve el campo 'description'
	 */
	public String getDescription() {
        return this.description;
    }
	/**
	 * @param description<String> - El campo 'description' a establecer
	 */
	public void setDescription( String description ) {
        this.description = description;
    }

	/**
	 * @return Se devuelve el campo 'name'
	 */
	public String getName() {
        return this.name;
    }
	/**
	 * @param name<String> - El campo 'name' a establecer
	 */
	public void setName( String name ) {
        this.name = name;
    }

	/**
	 * @return Se devuelve el campo 'createDate'
	 */
	public Date getCreateDate() {
        return this.createDate;
    }
	/**
	 * @param createDate<Date> - El campo 'createDate' a establecer
	 */
	public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }

	/**
	 * @return Se devuelve el campo 'approved'
	 */
	public String getApproved() {
        return this.approved;
    }
	/**
	 * @param approved<String> - El campo 'approved' a establecer
	 */
	public void setApproved( String approved ) {
        this.approved = approved;
    }

	/**
	 * @return Se devuelve el campo 'score'
	 */
	public Integer getScore() {
        return this.score;
    }
	/**
	 * @param score<Integer> - El campo 'score' a establecer
	 */
	public void setScore( Integer score ) {
        this.score = score;
    }

	/**
	 * @return Se devuelve el campo 'denounced'
	 */
	public String getDenounced() {
        return this.denounced;
    }
	/**
	 * @param denounced<String> - El campo 'denounced' a establecer
	 */
	public void setDenounced( String denounced ) {
        this.denounced = denounced;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Customers'
	 */
	public Customers getCustomers() {
        return this.customers;
    }
	/**
	 * @param customers<Customers> - La lista de objetos de tipo 'Customers' a establecer
	 */
	public void setCustomers( Customers customers ) {
        this.customers = customers;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'Items'
	 */
	public Items getItems() {
        return this.items;
    }
	/**
	 * @param items<Items> - La lista de objetos de tipo 'Items' a establecer
	 */
	public void setItems( Items items ) {
        this.items = items;
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
    	result = prime * result + ((description == null) ? 0 : description.hashCode());
    	result = prime * result + ((name == null) ? 0 : name.hashCode());
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    	result = prime * result + ((approved == null) ? 0 : approved.hashCode());
    	result = prime * result + ((score == null) ? 0 : score.hashCode());
    	result = prime * result + ((denounced == null) ? 0 : denounced.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		if (!(obj instanceof Comments)) {
			return false;
		}
		Comments other = (Comments) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
			return false;
		}
		if (approved == null) {
			if (other.approved != null) {
				return false;
			}
		} else if (!approved.equals(other.approved)) {
			return false;
		}
		if (score == null) {
			if (other.score != null) {
				return false;
			}
		} else if (!score.equals(other.score)) {
			return false;
		}
		if (denounced == null) {
			if (other.denounced != null) {
				return false;
			}
		} else if (!denounced.equals(other.denounced)) {
			return false;
		}
		if (customers == null) {
			if (other.customers != null) {
				return false;
			}
		} else if (!customers.equals(other.customers)) {
			return false;
		}
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
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
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}		
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}		
		if (createDate != null) {
			builder.append("createDate=");
			builder.append(createDate);
			builder.append(", ");
		}		
		if (approved != null) {
			builder.append("approved=");
			builder.append(approved);
			builder.append(", ");
		}		
		if (score != null) {
			builder.append("score=");
			builder.append(score);
			builder.append(", ");
		}		
		if (denounced != null) {
			builder.append("denounced=");
			builder.append(denounced);
			builder.append(", ");
		}		
		if (customers != null) {
			builder.append("customers=");
			builder.append(customers);
			builder.append(", ");
		}		
		if (items != null) {
			builder.append("items=");
			builder.append(items);
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

