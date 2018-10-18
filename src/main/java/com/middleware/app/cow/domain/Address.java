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
 * <p>Class Address.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:21 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Address"
 */
@Entity
@Table(name="Address")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Address.findAll", query="SELECT x FROM Address x" ),
  @NamedQuery ( name="Address.countAll", query="SELECT COUNT(x) FROM Address x" )
} )
public class Address extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_AddressEntity")
	@SequenceGenerator(name = "cow_generator_AddressEntity", sequenceName = "sq_Address", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="postal_code", nullable=false)
    private Integer postalCode;

    @Column(name="street", nullable=false, length=255)
    private String street;

    @Column(name="number", nullable=false)
    private Integer number;

    @Column(name="floor", nullable=false)
    private Integer floor;

    @Column(name="stairs", nullable=false)
    private Integer stairs;
    
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Location_id", referencedColumnName="id")
    private Location Location;
	
	@JsonIgnore
    @OneToMany(mappedBy="address", targetEntity=Order.class)
    private List<Order> listOfOrder;
	
    @ManyToOne
    @JoinColumn(name="User_id", referencedColumnName="id")
    private User User;
	

    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Address() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Address(Long id) {
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
	 * @return Se devuelve el campo 'postalCode'
	 */
	public Integer getPostalCode() {
        return this.postalCode;
    }
	/**
	 * @param postalCode<Integer> - El campo 'postalCode' a establecer
	 */
	public void setPostalCode( Integer postalCode ) {
        this.postalCode = postalCode;
    }

	/**
	 * @return Se devuelve el campo 'street'
	 */
	public String getStreet() {
        return this.street;
    }
	/**
	 * @param street<String> - El campo 'street' a establecer
	 */
	public void setStreet( String street ) {
        this.street = street;
    }

	/**
	 * @return Se devuelve el campo 'number'
	 */
	public Integer getNumber() {
        return this.number;
    }
	/**
	 * @param number<Integer> - El campo 'number' a establecer
	 */
	public void setNumber( Integer number ) {
        this.number = number;
    }

	/**
	 * @return Se devuelve el campo 'floor'
	 */
	public Integer getFloor() {
        return this.floor;
    }
	/**
	 * @param floor<Integer> - El campo 'floor' a establecer
	 */
	public void setFloor( Integer floor ) {
        this.floor = floor;
    }

	/**
	 * @return Se devuelve el campo 'stairs'
	 */
	public Integer getStairs() {
        return this.stairs;
    }
	/**
	 * @param stairs<Integer> - El campo 'stairs' a establecer
	 */
	public void setStairs( Integer stairs ) {
        this.stairs = stairs;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Location'
	 */
	public Location getLocation() {
        return this.Location;
    }
	/**
	 * @param Location<Location> - La lista de objetos de tipo 'Location' a establecer
	 */
	public void setLocation( Location Location ) {
        this.Location = Location;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Order>'
	 */
	public List<Order> getListOfOrder() {
        return this.listOfOrder;
    }
	/**
	 * @param listOfOrder<List<OrderEntity>> - La lista de objetos de tipo 'List<Order>' a establecer
	 */
	public void setListOfOrder( List<Order> listOfOrder ) {
        this.listOfOrder = listOfOrder;
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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
    	result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
    	result = prime * result + ((street == null) ? 0 : street.hashCode());
    	result = prime * result + ((number == null) ? 0 : number.hashCode());
    	result = prime * result + ((floor == null) ? 0 : floor.hashCode());
    	result = prime * result + ((stairs == null) ? 0 : stairs.hashCode());
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
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
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (floor == null) {
			if (other.floor != null) {
				return false;
			}
		} else if (!floor.equals(other.floor)) {
			return false;
		}
		if (stairs == null) {
			if (other.stairs != null) {
				return false;
			}
		} else if (!stairs.equals(other.stairs)) {
			return false;
		}
		if (Location == null) {
			if (other.Location != null) {
				return false;
			}
		} else if (!Location.equals(other.Location)) {
			return false;
		}
		if (!(listOfOrder instanceof List)) {
			if (!(other.listOfOrder instanceof List)) {
				if (listOfOrder == null) {
					if (other.listOfOrder != null) {
						return false;
					}
				} else if (!listOfOrder.equals(other.listOfOrder)) {
					return false;
				}
			}			
		} else if (other.listOfOrder != null && !(other.listOfOrder instanceof List)) {
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
		if (postalCode != null) {
			builder.append("postalCode=");
			builder.append(postalCode);
			builder.append(", ");
		}		
		if (street != null) {
			builder.append("street=");
			builder.append(street);
			builder.append(", ");
		}		
		if (number != null) {
			builder.append("number=");
			builder.append(number);
			builder.append(", ");
		}		
		if (floor != null) {
			builder.append("floor=");
			builder.append(floor);
			builder.append(", ");
		}		
		if (stairs != null) {
			builder.append("stairs=");
			builder.append(stairs);
			builder.append(", ");
		}		
		if (Location != null) {
			builder.append("Location=");
			builder.append(Location);
			builder.append(", ");
		}		
		if (listOfOrder != null && !(listOfOrder instanceof List)) {
			builder.append("listOfOrder=");
			builder.append(toString(listOfOrder, maxLen));
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

