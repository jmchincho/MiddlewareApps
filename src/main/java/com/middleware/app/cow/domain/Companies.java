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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Class Companies.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:21 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Companies"
 */
@Entity
@Table(name="Companies")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Companies.findAll", query="SELECT x FROM Companies x" ),
  @NamedQuery ( name="Companies.countAll", query="SELECT COUNT(x) FROM Companies x" )
} )
public class Companies extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_CompaniesEntity")
	@SequenceGenerator(name = "cow_generator_CompaniesEntity", sequenceName = "sq_Companies", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="logo", length=255)
    private String logo;

    @Column(name="cif", nullable=false, length=20)
    private String cif;

    @Column(name="url", length=255)
    private String url;

    @Column(name="url_state", nullable=false, length=1)
    private String urlState;

    @Column(name="telephone")
    private Integer telephone;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
	@JsonIgnore
    @OneToMany(mappedBy="companies", targetEntity=Subcription.class)
    private List<Subcription> listOfSubcription;
	
	@JsonIgnore
    @OneToMany(mappedBy="companies", targetEntity=Items.class)
    private List<Items> listOfItems;
	
	@OneToOne(mappedBy="company", targetEntity=Users.class)
    private Users users;


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Companies() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Companies(Long id) {
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
	 * @return Se devuelve el campo 'logo'
	 */
	public String getLogo() {
        return this.logo;
    }
	/**
	 * @param logo<String> - El campo 'logo' a establecer
	 */
	public void setLogo( String logo ) {
        this.logo = logo;
    }

	/**
	 * @return Se devuelve el campo 'cif'
	 */
	public String getCif() {
        return this.cif;
    }
	/**
	 * @param cif<String> - El campo 'cif' a establecer
	 */
	public void setCif( String cif ) {
        this.cif = cif;
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
	 * @return Se devuelve el campo 'urlState'
	 */
	public String getUrlState() {
        return this.urlState;
    }
	/**
	 * @param urlState<String> - El campo 'urlState' a establecer
	 */
	public void setUrlState( String urlState ) {
        this.urlState = urlState;
    }

	/**
	 * @return Se devuelve el campo 'telephone'
	 */
	public Integer getTelephone() {
        return this.telephone;
    }
	/**
	 * @param telephone<Integer> - El campo 'telephone' a establecer
	 */
	public void setTelephone( Integer telephone ) {
        this.telephone = telephone;
    }



    /**
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'List<Subcription>'
	 */
	public List<Subcription> getListOfSubcription() {
        return this.listOfSubcription;
    }
	/**
	 * @param listOfSubcription<List<SubcriptionEntity>> - La lista de objetos de tipo 'List<Subcription>' a establecer
	 */
	public void setListOfSubcription( List<Subcription> listOfSubcription ) {
        this.listOfSubcription = listOfSubcription;
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



    /**
	 * Get users.
	 *
	 * @return the users
	 */
	public Users getUsers() {
		return this.users;
	}

	/**
	 * Set users.
	 *
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
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
    	result = prime * result + ((logo == null) ? 0 : logo.hashCode());
    	result = prime * result + ((cif == null) ? 0 : cif.hashCode());
    	result = prime * result + ((url == null) ? 0 : url.hashCode());
    	result = prime * result + ((urlState == null) ? 0 : urlState.hashCode());
    	result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		if (!(obj instanceof Companies)) {
			return false;
		}
		Companies other = (Companies) obj;
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
		if (logo == null) {
			if (other.logo != null) {
				return false;
			}
		} else if (!logo.equals(other.logo)) {
			return false;
		}
		if (cif == null) {
			if (other.cif != null) {
				return false;
			}
		} else if (!cif.equals(other.cif)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (urlState == null) {
			if (other.urlState != null) {
				return false;
			}
		} else if (!urlState.equals(other.urlState)) {
			return false;
		}
		if (telephone == null) {
			if (other.telephone != null) {
				return false;
			}
		} else if (!telephone.equals(other.telephone)) {
			return false;
		}
		if (!(listOfSubcription instanceof List)) {
			if (!(other.listOfSubcription instanceof List)) {
				if (listOfSubcription == null) {
					if (other.listOfSubcription != null) {
						return false;
					}
				} else if (!listOfSubcription.equals(other.listOfSubcription)) {
					return false;
				}
			}			
		} else if (other.listOfSubcription != null && !(other.listOfSubcription instanceof List)) {
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
		if (logo != null) {
			builder.append("logo=");
			builder.append(logo);
			builder.append(", ");
		}		
		if (cif != null) {
			builder.append("cif=");
			builder.append(cif);
			builder.append(", ");
		}		
		if (url != null) {
			builder.append("url=");
			builder.append(url);
			builder.append(", ");
		}		
		if (urlState != null) {
			builder.append("urlState=");
			builder.append(urlState);
			builder.append(", ");
		}		
		if (telephone != null) {
			builder.append("telephone=");
			builder.append(telephone);
			builder.append(", ");
		}		
		if (listOfSubcription != null && !(listOfSubcription instanceof List)) {
			builder.append("listOfSubcription=");
			builder.append(toString(listOfSubcription, maxLen));
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

