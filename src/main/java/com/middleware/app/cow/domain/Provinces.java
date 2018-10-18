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
 * <p>Class Province.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Province"
 */
@Entity
@Table(name="Province")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Province.findAll", query="SELECT x FROM Province x" ),
  @NamedQuery ( name="Province.countAll", query="SELECT COUNT(x) FROM Province x" )
} )
public class Province extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_ProvinceEntity")
	@SequenceGenerator(name = "cow_generator_ProvinceEntity", sequenceName = "sq_Province", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="state", nullable=false, length=1)
    private String state;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Country_id", referencedColumnName="id")
    private Country Country;
	
	@JsonIgnore
    @OneToMany(mappedBy="Province", targetEntity=Location.class)
    private List<Location> listOfLocation;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Province() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Province(Long id) {
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
	 * @return Se devuelve la lista de objetos de tipo 'Country'
	 */
	public Country getCountry() {
        return this.Country;
    }
	/**
	 * @param Country<Country> - La lista de objetos de tipo 'Country' a establecer
	 */
	public void setCountry( Country Country ) {
        this.Country = Country;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Location>'
	 */
	public List<Location> getListOfLocation() {
        return this.listOfLocation;
    }
	/**
	 * @param listOfLocation<List<LocationEntity>> - La lista de objetos de tipo 'List<Location>' a establecer
	 */
	public void setListOfLocation( List<Location> listOfLocation ) {
        this.listOfLocation = listOfLocation;
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
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((Country == null) ? 0 : Country.hashCode());
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
		if (!(obj instanceof Province)) {
			return false;
		}
		Province other = (Province) obj;
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
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (Country == null) {
			if (other.Country != null) {
				return false;
			}
		} else if (!Country.equals(other.Country)) {
			return false;
		}
		if (!(listOfLocation instanceof List)) {
			if (!(other.listOfLocation instanceof List)) {
				if (listOfLocation == null) {
					if (other.listOfLocation != null) {
						return false;
					}
				} else if (!listOfLocation.equals(other.listOfLocation)) {
					return false;
				}
			}			
		} else if (other.listOfLocation != null && !(other.listOfLocation instanceof List)) {
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
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}		
		if (Country != null) {
			builder.append("Country=");
			builder.append(Country);
			builder.append(", ");
		}		
		if (listOfLocation != null && !(listOfLocation instanceof List)) {
			builder.append("listOfLocation=");
			builder.append(toString(listOfLocation, maxLen));
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

