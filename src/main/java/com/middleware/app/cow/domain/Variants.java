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
 * <p>Class Variant.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 27 abr 2017 ( Hora: 13:29:07 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Variant"
 */
@Entity
@Table(name="Variant")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Variant.findAll", query="SELECT x FROM Variant x" ),
  @NamedQuery ( name="Variant.countAll", query="SELECT COUNT(x) FROM Variant x" )
} )
public class Variant extends AbstractBase implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_VariantEntity")
	@SequenceGenerator(name = "cow_generator_VariantEntity", sequenceName = "sq_Variant", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="price", nullable=false)
    private Double price;

    @Column(name="state", nullable=false, length=1)
    private String state;

    @Column(name="size", length=4)
    private String size;

    @Column(name="color", length=2)
    private String color;

    @Column(name="stock", nullable=false)
    private Integer stock;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="finish_date")
    private Date finishDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publish_date", nullable=false)
    private Date publishDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;

    @Column(name="type", nullable=false, length=1)
    private String type;

    @Column(name="deleted", nullable=false)
    private Boolean deleted;
    
    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
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
	public Variant() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Variant(Long id) {
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
	 * @return Se devuelve el campo 'size'
	 */
	public String getSize() {
        return this.size;
    }
	/**
	 * @param size<String> - El campo 'size' a establecer
	 */
	public void setSize( String size ) {
        this.size = size;
    }

	/**
	 * @return Se devuelve el campo 'color'
	 */
	public String getColor() {
        return this.color;
    }
	/**
	 * @param color<String> - El campo 'color' a establecer
	 */
	public void setColor( String color ) {
        this.color = color;
    }

	/**
	 * @return Se devuelve el campo 'stock'
	 */
	public Integer getStock() {
        return this.stock;
    }
	/**
	 * @param stock<Integer> - El campo 'stock' a establecer
	 */
	public void setStock( Integer stock ) {
        this.stock = stock;
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
	 * @return Se devuelve el campo 'deleted'
	 */
	public Boolean getDeleted() {
        return this.deleted;
    }
	/**
	 * @param deleted<Boolean> - El campo 'deleted' a establecer
	 */
	public void setDeleted( Boolean deleted ) {
        this.deleted = deleted;
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
    	result = prime * result + ((size == null) ? 0 : size.hashCode());
    	result = prime * result + ((color == null) ? 0 : color.hashCode());
    	result = prime * result + ((stock == null) ? 0 : stock.hashCode());
    	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    	result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
    	result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    	result = prime * result + ((type == null) ? 0 : type.hashCode());
    	result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
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
		if (!(obj instanceof Variant)) {
			return false;
		}
		Variant other = (Variant) obj;
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
		if (size == null) {
			if (other.size != null) {
				return false;
			}
		} else if (!size.equals(other.size)) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (stock == null) {
			if (other.stock != null) {
				return false;
			}
		} else if (!stock.equals(other.stock)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
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
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (deleted == null) {
			if (other.deleted != null) {
				return false;
			}
		} else if (!deleted.equals(other.deleted)) {
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
		if (size != null) {
			builder.append("size=");
			builder.append(size);
			builder.append(", ");
		}		
		if (color != null) {
			builder.append("color=");
			builder.append(color);
			builder.append(", ");
		}		
		if (stock != null) {
			builder.append("stock=");
			builder.append(stock);
			builder.append(", ");
		}		
		if (startDate != null) {
			builder.append("startDate=");
			builder.append(startDate);
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
		if (type != null) {
			builder.append("type=");
			builder.append(type);
			builder.append(", ");
		}		
		if (deleted != null) {
			builder.append("deleted=");
			builder.append(deleted);
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

