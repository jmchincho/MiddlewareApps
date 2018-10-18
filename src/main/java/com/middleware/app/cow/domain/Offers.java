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


/**
 * <p>Class Offer.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Offer"
 */
@Entity
@Table(name="Offer")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Offer.findAll", query="SELECT x FROM Offer x" ),
  @NamedQuery ( name="Offer.countAll", query="SELECT COUNT(x) FROM Offer x" )
} )
public class Offer extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_OfferEntity")
	@SequenceGenerator(name = "cow_generator_OfferEntity", sequenceName = "sq_Offer", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="price", nullable=false)
    private Double price;

    @Column(name="state", nullable=false, length=1)
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date")
    private Date startDate;

    @Column(name="payment_type", length=1)
    private String paymentType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="finish_date")
    private Date finishDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publish_date", nullable=false)
    private Date publishDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Item_id", referencedColumnName="id")
    private Item Item;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Offer() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Offer(Long id) {
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
	 * @return Se devuelve el campo 'price'
	 */
	public Double getPrice() {
        return this.price;
    }
	/**
	 * @param price<Double> - El campo 'price' a establecer
	 */
	public void setPrice( Double price ) {
        this.price = price;
    }

	/**
	 * @return Se devuelve el campo 'state'
	 */
	public String getState() {
        return this.state;
    }
	/**
	 * @param state<String> - El campo 'state' a establecer
	 */
	public void setState( String state ) {
        this.state = state;
    }

	/**
	 * @return Se devuelve el campo 'startDate'
	 */
	public Date getStartDate() {
        return this.startDate;
    }
	/**
	 * @param startDate<Date> - El campo 'startDate' a establecer
	 */
	public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }

	/**
	 * Get paymentType.
	 *
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return this.paymentType;
	}

	/**
	 * Set paymentType.
	 *
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return Se devuelve el campo 'finishDate'
	 */
	public Date getFinishDate() {
        return this.finishDate;
    }
	/**
	 * @param finishDate<Date> - El campo 'finishDate' a establecer
	 */
	public void setFinishDate( Date finishDate ) {
        this.finishDate = finishDate;
    }

	/**
	 * @return Se devuelve el campo 'publishDate'
	 */
	public Date getPublishDate() {
        return this.publishDate;
    }
	/**
	 * @param publishDate<Date> - El campo 'publishDate' a establecer
	 */
	public void setPublishDate( Date publishDate ) {
        this.publishDate = publishDate;
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
	 * Getters & Setters para las relaciones
	 */
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
    	result = prime * result + ((price == null) ? 0 : price.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
    	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    	result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
    	result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
    	result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
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
		if (!(obj instanceof Offer)) {
			return false;
		}
		Offer other = (Offer) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (paymentType == null) {
			if (other.paymentType != null) {
				return false;
			}
		} else if (!paymentType.equals(other.paymentType)) {
			return false;
		}
		if (finishDate == null) {
			if (other.finishDate != null) {
				return false;
			}
		} else if (!finishDate.equals(other.finishDate)) {
			return false;
		}
		if (publishDate == null) {
			if (other.publishDate != null) {
				return false;
			}
		} else if (!publishDate.equals(other.publishDate)) {
			return false;
		}
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
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
		if (price != null) {
			builder.append("price=");
			builder.append(price);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (startDate != null) {
			builder.append("startDate=");
			builder.append(startDate);
			builder.append(", ");
		}		
		if (paymentType != null) {
			builder.append("paymentType=");
			builder.append(paymentType);
			builder.append(", ");
		}		
		if (finishDate != null) {
			builder.append("finishDate=");
			builder.append(finishDate);
			builder.append(", ");
		}		
		if (publishDate != null) {
			builder.append("publishDate=");
			builder.append(publishDate);
			builder.append(", ");
		}		
		if (createDate != null) {
			builder.append("createDate=");
			builder.append(createDate);
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

