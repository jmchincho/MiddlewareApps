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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * <p>Class Bannerads.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 9 abr 2017 ( Hora: 18:33:29 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "BannerAds"
 */
@Entity
@Table(name="Banner_Ads")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Bannerads.findAll", query="SELECT x FROM Bannerads x" ),
  @NamedQuery ( name="Bannerads.countAll", query="SELECT COUNT(x) FROM Bannerads x" )
} )
public class Bannerads extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_BanneradsEntity")
	@SequenceGenerator(name = "cow_generator_BanneradsEntity", sequenceName = "sq_BannerAds", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="title", nullable=false, length=50)
    private String title;

    @Column(name="description", nullable=false, length=120)
    private String description;

    @Column(name="orders", nullable=false)
    private Integer orders;

    @Column(name="state", nullable=false, length=1)
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable=false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="finish_date", nullable=false)
    private Date finishDate;

    @Column(name="image", length=255)
    private String image;

    @Column(name="url", length=255)
    private String url;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Bannerads() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Bannerads(Long id) {
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
	 * @return Se devuelve el campo 'title'
	 */
	public String getTitle() {
        return this.title;
    }
	/**
	 * @param title<String> - El campo 'title' a establecer
	 */
	public void setTitle( String title ) {
        this.title = title;
    }

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
	 * @return Se devuelve el campo 'orders'
	 */
	public Integer getOrders() {
        return this.orders;
    }
	/**
	 * @param orders<Integer> - El campo 'orders' a establecer
	 */
	public void setOrders( Integer orders ) {
        this.orders = orders;
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
	 * @return Se devuelve el campo 'image'
	 */
	public String getImage() {
        return this.image;
    }
	/**
	 * @param image<String> - El campo 'image' a establecer
	 */
	public void setImage( String image ) {
        this.image = image;
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
    	result = prime * result + ((title == null) ? 0 : title.hashCode());
    	result = prime * result + ((description == null) ? 0 : description.hashCode());
    	result = prime * result + ((orders == null) ? 0 : orders.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    	result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
    	result = prime * result + ((image == null) ? 0 : image.hashCode());
    	result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		if (!(obj instanceof Bannerads)) {
			return false;
		}
		Bannerads other = (Bannerads) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
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
		if (image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!image.equals(other.image)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
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
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}		
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}		
		if (orders != null) {
			builder.append("orders=");
			builder.append(orders);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (createDate != null) {
			builder.append("createDate=");
			builder.append(createDate);
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
		if (image != null) {
			builder.append("image=");
			builder.append(image);
			builder.append(", ");
		}		
		if (url != null) {
			builder.append("url=");
			builder.append(url);
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

