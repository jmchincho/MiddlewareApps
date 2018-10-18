// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * <p>Class Order.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Order"
 */
@Entity
@Table(name="Order")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Order.findAll", query="SELECT x FROM Order x" ),
  @NamedQuery ( name="Order.countAll", query="SELECT COUNT(x) FROM Order x" )
} )
public class Order extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_OrderEntity")
	@SequenceGenerator(name = "cow_generator_OrderEntity", sequenceName = "sq_Order", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_date", nullable=false)
    private Date modifyDate;

    @Column(name="payment_type", length=1)
    private String paymentType;

    @Column(name="paid_order", nullable=false, length=1)
    private String paidOrder;

    @Column(name="observations", length=500)
    private String observations;

    @Column(name="state", nullable=false, length=1)
    private String state;

    @Column(name="price_total", nullable=false)
    private Double priceTotal;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="address_id", referencedColumnName="id")
    private Address address;
	
	@JsonIgnore
    @OneToMany(mappedBy="Order", targetEntity=OrderDetail.class)
    private List<OrderDetail> listOfOrderDetail;
	
    @ManyToOne
    @JoinColumn(name="User_id", referencedColumnName="id")
    private User User;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Order() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Order(Long id) {
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
	 * @return Se devuelve el campo 'modifyDate'
	 */
	public Date getModifyDate() {
        return this.modifyDate;
    }
	/**
	 * @param modifyDate<Date> - El campo 'modifyDate' a establecer
	 */
	public void setModifyDate( Date modifyDate ) {
        this.modifyDate = modifyDate;
    }

	/**
	 * @return Se devuelve el campo 'paymentType'
	 */
	public String getPaymentType() {
        return this.paymentType;
    }
	/**
	 * @param paymentType<String> - El campo 'paymentType' a establecer
	 */
	public void setPaymentType( String paymentType ) {
        this.paymentType = paymentType;
    }

	/**
	 * @return Se devuelve el campo 'paidOrder'
	 */
	public String getPaidOrder() {
        return this.paidOrder;
    }
	/**
	 * @param paidOrder<String> - El campo 'paidOrder' a establecer
	 */
	public void setPaidOrder( String paidOrder ) {
        this.paidOrder = paidOrder;
    }

	/**
	 * @return Se devuelve el campo 'observations'
	 */
	public String getObservations() {
        return this.observations;
    }
	/**
	 * @param observations<String> - El campo 'observations' a establecer
	 */
	public void setObservations( String observations ) {
        this.observations = observations;
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
	 * @return Se devuelve el campo 'priceTotal'
	 */
	public Double getPriceTotal() {
        return this.priceTotal;
    }
	/**
	 * @param priceTotal<Double> - El campo 'priceTotal' a establecer
	 */
	public void setPriceTotal( Double priceTotal ) {
        this.priceTotal = priceTotal;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Address'
	 */
	public Address getAddress() {
        return this.address;
    }
	/**
	 * @param address<Address> - La lista de objetos de tipo 'Address' a establecer
	 */
	public void setAddress( Address address ) {
        this.address = address;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<OrderDetail>'
	 */
	public List<OrderDetail> getListOfOrderDetail() {
        return this.listOfOrderDetail;
    }
	/**
	 * @param listOfOrderDetail<List<OrderDetailEntity>> - La lista de objetos de tipo 'List<OrderDetail>' a establecer
	 */
	public void setListOfOrderDetail( List<OrderDetail> listOfOrderDetail ) {
        this.listOfOrderDetail = listOfOrderDetail;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'User'
	 */
	public User getUser() {
        return this.User;
    }
	/**
	 * @param User<User> - La lista de objetos de tipo 'User' a establecer
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
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    	result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
    	result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
    	result = prime * result + ((paidOrder == null) ? 0 : paidOrder.hashCode());
    	result = prime * result + ((observations == null) ? 0 : observations.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
    	result = prime * result + ((priceTotal == null) ? 0 : priceTotal.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
			return false;
		}
		if (modifyDate == null) {
			if (other.modifyDate != null) {
				return false;
			}
		} else if (!modifyDate.equals(other.modifyDate)) {
			return false;
		}
		if (paymentType == null) {
			if (other.paymentType != null) {
				return false;
			}
		} else if (!paymentType.equals(other.paymentType)) {
			return false;
		}
		if (paidOrder == null) {
			if (other.paidOrder != null) {
				return false;
			}
		} else if (!paidOrder.equals(other.paidOrder)) {
			return false;
		}
		if (observations == null) {
			if (other.observations != null) {
				return false;
			}
		} else if (!observations.equals(other.observations)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (priceTotal == null) {
			if (other.priceTotal != null) {
				return false;
			}
		} else if (!priceTotal.equals(other.priceTotal)) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (!(listOfOrderDetail instanceof List)) {
			if (!(other.listOfOrderDetail instanceof List)) {
				if (listOfOrderDetail == null) {
					if (other.listOfOrderDetail != null) {
						return false;
					}
				} else if (!listOfOrderDetail.equals(other.listOfOrderDetail)) {
					return false;
				}
			}			
		} else if (other.listOfOrderDetail != null && !(other.listOfOrderDetail instanceof List)) {
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
		if (createDate != null) {
			builder.append("createDate=");
			builder.append(createDate);
			builder.append(", ");
		}		
		if (modifyDate != null) {
			builder.append("modifyDate=");
			builder.append(modifyDate);
			builder.append(", ");
		}		
		if (paymentType != null) {
			builder.append("paymentType=");
			builder.append(paymentType);
			builder.append(", ");
		}		
		if (paidOrder != null) {
			builder.append("paidOrder=");
			builder.append(paidOrder);
			builder.append(", ");
		}		
		if (observations != null) {
			builder.append("observations=");
			builder.append(observations);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (priceTotal != null) {
			builder.append("priceTotal=");
			builder.append(priceTotal);
			builder.append(", ");
		}		
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}		
		if (listOfOrderDetail != null && !(listOfOrderDetail instanceof List)) {
			builder.append("listOfOrderDetail=");
			builder.append(toString(listOfOrderDetail, maxLen));
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

