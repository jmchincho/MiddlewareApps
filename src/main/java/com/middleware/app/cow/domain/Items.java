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
 * <p>Class Items.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Items"
 */
@Entity
@Table(name="Items")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Items.findAll", query="SELECT x FROM Items x" ),
  @NamedQuery ( name="Items.countAll", query="SELECT COUNT(x) FROM Items x" )
} )
public class Items extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_ItemsEntity")
	@SequenceGenerator(name = "cow_generator_ItemsEntity", sequenceName = "sq_Items", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=255)
    private String name;

    @Column(name="descriptions", length=1000)
    private String descriptions;

    @Column(name="conditions", length=1000)
    private String conditions;

    @Column(name="price", nullable=false)
    private Double price;

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

    @Column(name="url", length=255)
    private String url;

    @Column(name="image1", length=255)
    private String image1;

    @Column(name="image2", length=255)
    private String image2;

    @Column(name="image3", length=255)
    private String image3;

    @Column(name="image4", length=255)
    private String image4;

    @Column(name="send_price", nullable=false)
    private Double sendPrice;

    @Column(name="image5", length=255)
    private String image5;

    @Column(name="send_type", nullable=false, length=1)
    private String sendType;

    @Column(name="state", nullable=false, length=1)
    private String state;

    @Column(name="type", nullable=false, length=1)
    private String type;

    @Column(name="dates", nullable=false)
    private boolean dates;

    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="subcategories_id", referencedColumnName="id")
    private Subcategories subcategories;
	
    @ManyToOne
    @JoinColumn(name="companies_id", referencedColumnName="id")
    private Companies companies;
	
	//@JsonIgnore
    @OneToMany( mappedBy="items", targetEntity=Comments.class)
    private List<Comments> comments;
	
	@JsonIgnore
    @OneToMany(mappedBy="items", targetEntity=Offers.class)
    private List<Offers> listOfOffers;
	
	@JsonIgnore
    @OneToMany(mappedBy="items", targetEntity=OrdersDetails.class)
    private List<OrdersDetails> listOfOrdersDetails;
	
//	@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy="items", targetEntity=Variants.class)
    private List<Variants> variants;

    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Items() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Items(Long id) {
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
	 * @return Se devuelve el campo 'descriptions'
	 */
	public String getDescriptions() {
        return this.descriptions;
    }
	/**
	 * @param descriptions<String> - El campo 'descriptions' a establecer
	 */
	public void setDescriptions( String descriptions ) {
        this.descriptions = descriptions;
    }

	/**
	 * @return Se devuelve el campo 'conditions'
	 */
	public String getConditions() {
        return this.conditions;
    }
	/**
	 * @param conditions<String> - El campo 'conditions' a establecer
	 */
	public void setConditions( String conditions ) {
        this.conditions = conditions;
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
	 * @return Se devuelve el campo 'url'
	 */
	public String getUrl() {
        return this.url;
    }
	/**
	 * @param url<String> - El campo 'url' a establecer
	 */
	public void setUrl( String url ) {
        this.url = url;
    }

	/**
	 * @return Se devuelve el campo 'image1'
	 */
	public String getImage1() {
        return this.image1;
    }
	/**
	 * @param image1<String> - El campo 'image1' a establecer
	 */
	public void setImage1( String image1 ) {
        this.image1 = image1;
    }

	/**
	 * @return Se devuelve el campo 'image2'
	 */
	public String getImage2() {
        return this.image2;
    }
	/**
	 * @param image2<String> - El campo 'image2' a establecer
	 */
	public void setImage2( String image2 ) {
        this.image2 = image2;
    }

	/**
	 * @return Se devuelve el campo 'image3'
	 */
	public String getImage3() {
        return this.image3;
    }
	/**
	 * @param image3<String> - El campo 'image3' a establecer
	 */
	public void setImage3( String image3 ) {
        this.image3 = image3;
    }

	/**
	 * @return Se devuelve el campo 'image4'
	 */
	public String getImage4() {
        return this.image4;
    }
	/**
	 * @param image4<String> - El campo 'image4' a establecer
	 */
	public void setImage4( String image4 ) {
        this.image4 = image4;
    }

	/**
	 * @return Se devuelve el campo 'sendPrice'
	 */
	public Double getSendPrice() {
        return this.sendPrice;
    }
	/**
	 * @param sendPrice<Double> - El campo 'sendPrice' a establecer
	 */
	public void setSendPrice( Double sendPrice ) {
        this.sendPrice = sendPrice;
    }

	/**
	 * @return Se devuelve el campo 'image5'
	 */
	public String getImage5() {
        return this.image5;
    }
	/**
	 * @param image5<String> - El campo 'image5' a establecer
	 */
	public void setImage5( String image5 ) {
        this.image5 = image5;
    }

	/**
	 * @return Se devuelve el campo 'sendType'
	 */
	public String getSendType() {
        return this.sendType;
    }
	/**
	 * @param sendType<String> - El campo 'sendType' a establecer
	 */
	public void setSendType( String sendType ) {
        this.sendType = sendType;
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
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Subcategories'
	 */
	public Subcategories getSubcategories() {
        return this.subcategories;
    }
	/**
	 * @param subcategories<Subcategories> - La lista de objetos de tipo 'Subcategories' a establecer
	 */
	public void setSubcategories( Subcategories subcategories ) {
        this.subcategories = subcategories;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'Companies'
	 */
	public Companies getCompanies() {
        return this.companies;
    }
	/**
	 * @param companies<Companies> - La lista de objetos de tipo 'Companies' a establecer
	 */
	public void setCompanies( Companies companies ) {
        this.companies = companies;
    }

	/**
	 * Get dates.
	 *
	 * @return the dates
	 */
	public boolean isDates() {
		return this.dates;
	}

	/**
	 * Set dates.
	 *
	 * @param dates the dates to set
	 */
	public void setDates(boolean dates) {
		this.dates = dates;
	}

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Comments>'
	 */
	public List<Comments> getComments() {
        return this.comments;
    }
	/**
	 * @param comments<List<CommentsEntity>> - La lista de objetos de tipo 'List<Comments>' a establecer
	 */
	public void setComments( List<Comments> comments ) {
        this.comments = comments;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Offers>'
	 */
	public List<Offers> getListOfOffers() {
        return this.listOfOffers;
    }
	/**
	 * @param listOfOffers<List<OffersEntity>> - La lista de objetos de tipo 'List<Offers>' a establecer
	 */
	public void setListOfOffers( List<Offers> listOfOffers ) {
        this.listOfOffers = listOfOffers;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<OrdersDetails>'
	 */
	public List<OrdersDetails> getListOfOrdersDetails() {
        return this.listOfOrdersDetails;
    }
	/**
	 * @param listOfOrdersDetails<List<OrdersDetailsEntity>> - La lista de objetos de tipo 'List<OrdersDetails>' a establecer
	 */
	public void setListOfOrdersDetails( List<OrdersDetails> listOfOrdersDetails ) {
        this.listOfOrdersDetails = listOfOrdersDetails;
    }

    /**
	 * @return the variants
	 */
	public List<Variants> getVariants() {
		return variants;
	}

	/**
	 * @param variants the variants to set
	 */
	public void setVariants(List<Variants> variants) {
		this.variants = variants;
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
    	result = prime * result + ((name == null) ? 0 : name.hashCode());
    	result = prime * result + ((descriptions == null) ? 0 : descriptions.hashCode());
    	result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
    	result = prime * result + ((price == null) ? 0 : price.hashCode());
    	result = prime * result + ((stock == null) ? 0 : stock.hashCode());
    	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    	result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
    	result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    	result = prime * result + ((url == null) ? 0 : url.hashCode());
    	result = prime * result + ((image1 == null) ? 0 : image1.hashCode());
    	result = prime * result + ((image2 == null) ? 0 : image2.hashCode());
    	result = prime * result + ((image3 == null) ? 0 : image3.hashCode());
    	result = prime * result + ((image4 == null) ? 0 : image4.hashCode());
    	result = prime * result + ((sendPrice == null) ? 0 : sendPrice.hashCode());
    	result = prime * result + ((image5 == null) ? 0 : image5.hashCode());
    	result = prime * result + ((sendType == null) ? 0 : sendType.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
    	result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((subcategories == null) ? 0 : subcategories.hashCode());
		result = prime * result + ((companies == null) ? 0 : companies.hashCode());
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
		if (!(obj instanceof Items)) {
			return false;
		}
		Items other = (Items) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (descriptions == null) {
			if (other.descriptions != null) {
				return false;
			}
		} else if (!descriptions.equals(other.descriptions)) {
			return false;
		}
		if (conditions == null) {
			if (other.conditions != null) {
				return false;
			}
		} else if (!conditions.equals(other.conditions)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
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
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (image1 == null) {
			if (other.image1 != null) {
				return false;
			}
		} else if (!image1.equals(other.image1)) {
			return false;
		}
		if (image2 == null) {
			if (other.image2 != null) {
				return false;
			}
		} else if (!image2.equals(other.image2)) {
			return false;
		}
		if (image3 == null) {
			if (other.image3 != null) {
				return false;
			}
		} else if (!image3.equals(other.image3)) {
			return false;
		}
		if (image4 == null) {
			if (other.image4 != null) {
				return false;
			}
		} else if (!image4.equals(other.image4)) {
			return false;
		}
		if (sendPrice == null) {
			if (other.sendPrice != null) {
				return false;
			}
		} else if (!sendPrice.equals(other.sendPrice)) {
			return false;
		}
		if (image5 == null) {
			if (other.image5 != null) {
				return false;
			}
		} else if (!image5.equals(other.image5)) {
			return false;
		}
		if (sendType == null) {
			if (other.sendType != null) {
				return false;
			}
		} else if (!sendType.equals(other.sendType)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (subcategories == null) {
			if (other.subcategories != null) {
				return false;
			}
		} else if (!subcategories.equals(other.subcategories)) {
			return false;
		}
		if (companies == null) {
			if (other.companies != null) {
				return false;
			}
		} else if (!companies.equals(other.companies)) {
			return false;
		}
		if (!(comments instanceof List)) {
			if (!(other.comments instanceof List)) {
				if (comments == null) {
					if (other.comments != null) {
						return false;
					}
				} else if (!comments.equals(other.comments)) {
					return false;
				}
			}			
		} else if (other.comments != null && !(other.comments instanceof List)) {
			return false;
		}
		if (!(listOfOffers instanceof List)) {
			if (!(other.listOfOffers instanceof List)) {
				if (listOfOffers == null) {
					if (other.listOfOffers != null) {
						return false;
					}
				} else if (!listOfOffers.equals(other.listOfOffers)) {
					return false;
				}
			}			
		} else if (other.listOfOffers != null && !(other.listOfOffers instanceof List)) {
			return false;
		}
		if (!(listOfOrdersDetails instanceof List)) {
			if (!(other.listOfOrdersDetails instanceof List)) {
				if (listOfOrdersDetails == null) {
					if (other.listOfOrdersDetails != null) {
						return false;
					}
				} else if (!listOfOrdersDetails.equals(other.listOfOrdersDetails)) {
					return false;
				}
			}			
		} else if (other.listOfOrdersDetails != null && !(other.listOfOrdersDetails instanceof List)) {
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
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}		
		if (descriptions != null) {
			builder.append("descriptions=");
			builder.append(descriptions);
			builder.append(", ");
		}		
		if (conditions != null) {
			builder.append("conditions=");
			builder.append(conditions);
			builder.append(", ");
		}		
		if (price != null) {
			builder.append("price=");
			builder.append(price);
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
		if (url != null) {
			builder.append("url=");
			builder.append(url);
			builder.append(", ");
		}		
		if (image1 != null) {
			builder.append("image1=");
			builder.append(image1);
			builder.append(", ");
		}		
		if (image2 != null) {
			builder.append("image2=");
			builder.append(image2);
			builder.append(", ");
		}		
		if (image3 != null) {
			builder.append("image3=");
			builder.append(image3);
			builder.append(", ");
		}		
		if (image4 != null) {
			builder.append("image4=");
			builder.append(image4);
			builder.append(", ");
		}		
		if (sendPrice != null) {
			builder.append("sendPrice=");
			builder.append(sendPrice);
			builder.append(", ");
		}		
		if (image5 != null) {
			builder.append("image5=");
			builder.append(image5);
			builder.append(", ");
		}		
		if (sendType != null) {
			builder.append("sendType=");
			builder.append(sendType);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (type != null) {
			builder.append("type=");
			builder.append(type);
			builder.append(", ");
		}		
		if (subcategories != null) {
			builder.append("subcategories=");
			builder.append(subcategories);
			builder.append(", ");
		}		
		if (companies != null) {
			builder.append("companies=");
			builder.append(companies);
			builder.append(", ");
		}		
		if (comments != null && !(comments instanceof List)) {
			builder.append("comments=");
			builder.append(toString(comments, maxLen));
			builder.append(", ");
		}		
		if (listOfOffers != null && !(listOfOffers instanceof List)) {
			builder.append("listOfOffers=");
			builder.append(toString(listOfOffers, maxLen));
			builder.append(", ");
		}		
		if (listOfOrdersDetails != null && !(listOfOrdersDetails instanceof List)) {
			builder.append("listOfOrdersDetails=");
			builder.append(toString(listOfOrdersDetails, maxLen));
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

