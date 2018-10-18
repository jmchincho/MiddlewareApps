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
 * <p>Class Subcategory.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Subcategory"
 */
@Entity
@Table(name="Sub_Category")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Subcategory.findAll", query="SELECT x FROM Subcategory x" ),
  @NamedQuery ( name="Subcategory.countAll", query="SELECT COUNT(x) FROM Subcategory x" )
} )
public class Subcategory extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_SubcategoryEntity")
	@SequenceGenerator(name = "cow_generator_SubcategoryEntity", sequenceName = "sq_Subcategory", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="Order", nullable=false)
    private Integer Order;

    @Column(name="state", nullable=false, length=1)
    private String state;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Category_id", referencedColumnName="id")
    private Category Category;
	
	@JsonIgnore
    @OneToMany(mappedBy="Subcategory", targetEntity=Item.class)
    private List<Item> listOfItem;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Subcategory() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Subcategory(Long id) {
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
	 * @return Se devuelve el campo 'Order'
	 */
	public Integer getOrder() {
        return this.Order;
    }
	/**
	 * @param Order<Integer> - El campo 'Order' a establecer
	 */
	public void setOrder( Integer Order ) {
        this.Order = Order;
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
	 * @return Se devuelve la lista de objetos de tipo 'Category'
	 */
	public Category getCategory() {
        return this.Category;
    }
	/**
	 * @param Category<Category> - La lista de objetos de tipo 'Category' a establecer
	 */
	public void setCategory( Category Category ) {
        this.Category = Category;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Item>'
	 */
	public List<Item> getListOfItem() {
        return this.listOfItem;
    }
	/**
	 * @param listOfItem<List<ItemEntity>> - La lista de objetos de tipo 'List<Item>' a establecer
	 */
	public void setListOfItem( List<Item> listOfItem ) {
        this.listOfItem = listOfItem;
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
    	result = prime * result + ((Order == null) ? 0 : Order.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((Category == null) ? 0 : Category.hashCode());
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
		if (!(obj instanceof Subcategory)) {
			return false;
		}
		Subcategory other = (Subcategory) obj;
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
		if (Order == null) {
			if (other.Order != null) {
				return false;
			}
		} else if (!Order.equals(other.Order)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (Category == null) {
			if (other.Category != null) {
				return false;
			}
		} else if (!Category.equals(other.Category)) {
			return false;
		}
		if (!(listOfItem instanceof List)) {
			if (!(other.listOfItem instanceof List)) {
				if (listOfItem == null) {
					if (other.listOfItem != null) {
						return false;
					}
				} else if (!listOfItem.equals(other.listOfItem)) {
					return false;
				}
			}			
		} else if (other.listOfItem != null && !(other.listOfItem instanceof List)) {
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
		if (Order != null) {
			builder.append("Order=");
			builder.append(Order);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (Category != null) {
			builder.append("Category=");
			builder.append(Category);
			builder.append(", ");
		}		
		if (listOfItem != null && !(listOfItem instanceof List)) {
			builder.append("listOfItem=");
			builder.append(toString(listOfItem, maxLen));
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

