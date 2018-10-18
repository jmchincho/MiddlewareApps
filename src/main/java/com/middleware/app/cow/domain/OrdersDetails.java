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
 * <p>Class OrderDetail.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Order_Details"
 */
@Entity
@Table(name="Order_Details")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="OrderDetail.findAll", query="SELECT x FROM OrderDetail x" ),
  @NamedQuery ( name="OrderDetail.countAll", query="SELECT COUNT(x) FROM OrderDetail x" )
} )
public class OrderDetail extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_OrderDetailEntity")
	@SequenceGenerator(name = "cow_generator_OrderDetailEntity", sequenceName = "sq_Order_Details", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="quantity", nullable=false)
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    @Column(name="send_date")
    private Date sendDate;

    @Temporal(TemporalType.DATE)
    @Column(name="delivered_date")
    private Date deliveredDate;

    @Temporal(TemporalType.DATE)
    @Column(name="cancelled_date")
    private Date cancelledDate;

    @Column(name="send_state", nullable=false, length=1)
    private String sendState;

    @Column(name="price", nullable=false)
    private Double price;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Item_id", referencedColumnName="id")
    private Item Item;
	
    @ManyToOne
    @JoinColumn(name="Order_id", referencedColumnName="id")
    private Order Order;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public OrderDetail() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public OrderDetail(Long id) {
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
	 * @return Se devuelve el campo 'quantity'
	 */
	public Integer getQuantity() {
        return this.quantity;
    }
	/**
	 * @param quantity<Integer> - El campo 'quantity' a establecer
	 */
	public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }

	/**
	 * @return Se devuelve el campo 'sendDate'
	 */
	public Date getSendDate() {
        return this.sendDate;
    }
	/**
	 * @param sendDate<Date> - El campo 'sendDate' a establecer
	 */
	public void setSendDate( Date sendDate ) {
        this.sendDate = sendDate;
    }

	/**
	 * @return Se devuelve el campo 'deliveredDate'
	 */
	public Date getDeliveredDate() {
        return this.deliveredDate;
    }
	/**
	 * @param deliveredDate<Date> - El campo 'deliveredDate' a establecer
	 */
	public void setDeliveredDate( Date deliveredDate ) {
        this.deliveredDate = deliveredDate;
    }

	/**
	 * @return Se devuelve el campo 'cancelledDate'
	 */
	public Date getCancelledDate() {
        return this.cancelledDate;
    }
	/**
	 * @param cancelledDate<Date> - El campo 'cancelledDate' a establecer
	 */
	public void setCancelledDate( Date cancelledDate ) {
        this.cancelledDate = cancelledDate;
    }

	/**
	 * @return Se devuelve el campo 'sendState'
	 */
	public String getSendState() {
        return this.sendState;
    }
	/**
	 * @param sendState<String> - El campo 'sendState' a establecer
	 */
	public void setSendState( String sendState ) {
        this.sendState = sendState;
    }

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

	/**
	 * @return Se devuelve la lista de objetos de tipo 'Order'
	 */
	public Order getOrder() {
        return this.Order;
    }
	/**
	 * @param Order<Order> - La lista de objetos de tipo 'Order' a establecer
	 */
	public void setOrder( Order Order ) {
        this.Order = Order;
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
    	result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
    	result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
    	result = prime * result + ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
    	result = prime * result + ((cancelledDate == null) ? 0 : cancelledDate.hashCode());
    	result = prime * result + ((sendState == null) ? 0 : sendState.hashCode());
    	result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((Item == null) ? 0 : Item.hashCode());
		result = prime * result + ((Order == null) ? 0 : Order.hashCode());
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
		if (!(obj instanceof OrderDetail)) {
			return false;
		}
		OrderDetail other = (OrderDetail) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		if (sendDate == null) {
			if (other.sendDate != null) {
				return false;
			}
		} else if (!sendDate.equals(other.sendDate)) {
			return false;
		}
		if (deliveredDate == null) {
			if (other.deliveredDate != null) {
				return false;
			}
		} else if (!deliveredDate.equals(other.deliveredDate)) {
			return false;
		}
		if (cancelledDate == null) {
			if (other.cancelledDate != null) {
				return false;
			}
		} else if (!cancelledDate.equals(other.cancelledDate)) {
			return false;
		}
		if (sendState == null) {
			if (other.sendState != null) {
				return false;
			}
		} else if (!sendState.equals(other.sendState)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (Item == null) {
			if (other.Item != null) {
				return false;
			}
		} else if (!Item.equals(other.Item)) {
			return false;
		}
		if (Order == null) {
			if (other.Order != null) {
				return false;
			}
		} else if (!Order.equals(other.Order)) {
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
		if (quantity != null) {
			builder.append("quantity=");
			builder.append(quantity);
			builder.append(", ");
		}		
		if (sendDate != null) {
			builder.append("sendDate=");
			builder.append(sendDate);
			builder.append(", ");
		}		
		if (deliveredDate != null) {
			builder.append("deliveredDate=");
			builder.append(deliveredDate);
			builder.append(", ");
		}		
		if (cancelledDate != null) {
			builder.append("cancelledDate=");
			builder.append(cancelledDate);
			builder.append(", ");
		}		
		if (sendState != null) {
			builder.append("sendState=");
			builder.append(sendState);
			builder.append(", ");
		}		
		if (price != null) {
			builder.append("price=");
			builder.append(price);
			builder.append(", ");
		}		
		if (Item != null) {
			builder.append("Item=");
			builder.append(Item);
			builder.append(", ");
		}		
		if (Order != null) {
			builder.append("Order=");
			builder.append(Order);
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

