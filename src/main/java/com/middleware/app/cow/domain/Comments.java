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
 * <p>Class Comment.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:21 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Comment"
 */
@Entity
@Table(name="Comment")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Comment.findAll", query="SELECT x FROM Comment x" ),
  @NamedQuery ( name="Comment.countAll", query="SELECT COUNT(x) FROM Comment x" )
} )
public class Comment extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_CommentEntity")
	@SequenceGenerator(name = "cow_generator_CommentEntity", sequenceName = "sq_Comment", alLocationize = 1)
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
    @JoinColumn(name="Customer_id", referencedColumnName="id")
    private Customer Customer;
	
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="Item_id", referencedColumnName="id")
    private Item Item;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Comment() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Comment(Long id) {
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
	 * @return Se devuelve la lista de objetos de tipo 'Customer'
	 */
	public Customer getCustomer() {
        return this.Customer;
    }
	/**
	 * @param Customer<Customer> - La lista de objetos de tipo 'Customer' a establecer
	 */
	public void setCustomer( Customer Customer ) {
        this.Customer = Customer;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'Item'
	 */
	public Item getItem() {
        return this.Item;
    }
	/**
	 * @param Item<Item> - La lista de objetos de tipo 'Item' a establecer
	 */
	public void setItem( Item Item ) {
        this.Item = Item;
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
		result = prime * result + ((Customer == null) ? 0 : Customer.hashCode());
		result = prime * result + ((Item == null) ? 0 : Item.hashCode());
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
		if (!(obj instanceof Comment)) {
			return false;
		}
		Comment other = (Comment) obj;
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
		if (Customer == null) {
			if (other.Customer != null) {
				return false;
			}
		} else if (!Customer.equals(other.Customer)) {
			return false;
		}
		if (Item == null) {
			if (other.Item != null) {
				return false;
			}
		} else if (!Item.equals(other.Item)) {
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
		if (Customer != null) {
			builder.append("Customer=");
			builder.append(Customer);
			builder.append(", ");
		}		
		if (Item != null) {
			builder.append("Item=");
			builder.append(Item);
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

