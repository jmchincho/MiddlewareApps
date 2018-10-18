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
 * <p>Class Customer.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Customer"
 */
@Entity
@Table(name="Customer")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Customer.findAll", query="SELECT x FROM Customer x" ),
  @NamedQuery ( name="Customer.countAll", query="SELECT COUNT(x) FROM Customer x" )
} )
public class Customer extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_CustomerEntity")
	@SequenceGenerator(name = "cow_generator_CustomerEntity", sequenceName = "sq_Customer", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="surname", nullable=false, length=100)
    private String surname;

    @Column(name="dni", nullable=false, length=9)
    private String dni;

    @Column(name="telephone", nullable=false)
    private Integer telephone;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
	
	@OneToOne(mappedBy="customer", targetEntity=User.class)
    private User User;
	
	@JsonIgnore
    @OneToMany(mappedBy="Customer", targetEntity=Subcription.class)
    private List<Subcription> listOfSubcription;
	
	@JsonIgnore
    @OneToMany(mappedBy="Customer", targetEntity=Comment.class)
    private List<Comment> listOfComment;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Customer() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Customer(Long id) {
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
	 * @return Se devuelve el campo 'surname'
	 */
	public String getSurname() {
        return this.surname;
    }
	/**
	 * @param surname<String> - El campo 'surname' a establecer
	 */
	public void setSurname( String surname ) {
        this.surname = surname;
    }

	/**
	 * @return Se devuelve el campo 'dni'
	 */
	public String getDni() {
        return this.dni;
    }
	/**
	 * @param dni<String> - El campo 'dni' a establecer
	 */
	public void setDni( String dni ) {
        this.dni = dni;
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
	 * @return Se devuelve la lista de objetos de tipo 'List<Comment>'
	 */
	public List<Comment> getListOfComment() {
        return this.listOfComment;
    }
	/**
	 * @param listOfComment<List<CommentEntity>> - La lista de objetos de tipo 'List<Comment>' a establecer
	 */
	public void setListOfComment( List<Comment> listOfComment ) {
        this.listOfComment = listOfComment;
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
    	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
    	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
    	result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
//		result = prime * result + ((User == null) ? 0 : User.hashCode());
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
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
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
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		if (telephone == null) {
			if (other.telephone != null) {
				return false;
			}
		} else if (!telephone.equals(other.telephone)) {
			return false;
		}
		if (User == null) {
			if (other.User != null) {
				return false;
			}
		} else if (!User.equals(other.User)) {
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
		if (!(listOfComment instanceof List)) {
			if (!(other.listOfComment instanceof List)) {
				if (listOfComment == null) {
					if (other.listOfComment != null) {
						return false;
					}
				} else if (!listOfComment.equals(other.listOfComment)) {
					return false;
				}
			}			
		} else if (other.listOfComment != null && !(other.listOfComment instanceof List)) {
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
		if (surname != null) {
			builder.append("surname=");
			builder.append(surname);
			builder.append(", ");
		}		
		if (dni != null) {
			builder.append("dni=");
			builder.append(dni);
			builder.append(", ");
		}			
		if (telephone != null) {
			builder.append("telephone=");
			builder.append(telephone);
			builder.append(", ");
		}		
		if (User != null) {
			builder.append("User=");
			builder.append(User);
			builder.append(", ");
		}		
		if (listOfSubcription != null && !(listOfSubcription instanceof List)) {
			builder.append("listOfSubcription=");
			builder.append(toString(listOfSubcription, maxLen));
			builder.append(", ");
		}		
		if (listOfComment != null && !(listOfComment instanceof List)) {
			builder.append("listOfComment=");
			builder.append(toString(listOfComment, maxLen));
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

