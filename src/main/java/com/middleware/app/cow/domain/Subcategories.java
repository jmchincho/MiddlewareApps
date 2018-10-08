// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
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



import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Class Subcategories.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "SubCategories"
 */
@Entity
@Table(name="Sub_Categories")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Subcategories.findAll", query="SELECT x FROM Subcategories x" ),
  @NamedQuery ( name="Subcategories.countAll", query="SELECT COUNT(x) FROM Subcategories x" )
} )
public class Subcategories extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_SubcategoriesEntity")
	@SequenceGenerator(name = "cow_generator_SubcategoriesEntity", sequenceName = "sq_SubCategories", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="orders", nullable=false)
    private Integer orders;

    @Column(name="state", nullable=false, length=1)
    private String state;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="categories_id", referencedColumnName="id")
    private Categories categories;
	
	@JsonIgnore
    @OneToMany(mappedBy="subcategories", targetEntity=Items.class)
    private List<Items> listOfItems;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Subcategories() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Subcategories(Long id) {
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
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Categories'
	 */
	public Categories getCategories() {
        return this.categories;
    }
	/**
	 * @param categories<Categories> - La lista de objetos de tipo 'Categories' a establecer
	 */
	public void setCategories( Categories categories ) {
        this.categories = categories;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Items>'
	 */
	public List<Items> getListOfItems() {
        return this.listOfItems;
    }
	/**
	 * @param listOfItems<List<ItemsEntity>> - La lista de objetos de tipo 'List<Items>' a establecer
	 */
	public void setListOfItems( List<Items> listOfItems ) {
        this.listOfItems = listOfItems;
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
    	result = prime * result + ((orders == null) ? 0 : orders.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
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
		if (!(obj instanceof Subcategories)) {
			return false;
		}
		Subcategories other = (Subcategories) obj;
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
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (!(listOfItems instanceof List)) {
			if (!(other.listOfItems instanceof List)) {
				if (listOfItems == null) {
					if (other.listOfItems != null) {
						return false;
					}
				} else if (!listOfItems.equals(other.listOfItems)) {
					return false;
				}
			}			
		} else if (other.listOfItems != null && !(other.listOfItems instanceof List)) {
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
		if (categories != null) {
			builder.append("categories=");
			builder.append(categories);
			builder.append(", ");
		}		
		if (listOfItems != null && !(listOfItems instanceof List)) {
			builder.append("listOfItems=");
			builder.append(toString(listOfItems, maxLen));
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

