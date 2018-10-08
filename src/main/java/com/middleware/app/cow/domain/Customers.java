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
 * <p>Class Customers.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Customers"
 */
@Entity
@Table(name="Customers")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Customers.findAll", query="SELECT x FROM Customers x" ),
  @NamedQuery ( name="Customers.countAll", query="SELECT COUNT(x) FROM Customers x" )
} )
public class Customers extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_CustomersEntity")
	@SequenceGenerator(name = "cow_generator_CustomersEntity", sequenceName = "sq_Customers", allocationSize = 1)
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
	
	@OneToOne(mappedBy="customer", targetEntity=Users.class)
    private Users users;
	
	@JsonIgnore
    @OneToMany(mappedBy="customers", targetEntity=Subcription.class)
    private List<Subcription> listOfSubcription;
	
	@JsonIgnore
    @OneToMany(mappedBy="customers", targetEntity=Comments.class)
    private List<Comments> listOfComments;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Customers() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Customers(Long id) {
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
	 * @return Se devuelve la lista de objetos de tipo 'Users'
	 */
	public Users getUsers() {
        return this.users;
    }
	/**
	 * @param users<Users> - La lista de objetos de tipo 'Users' a establecer
	 */
	public void setUsers( Users users ) {
        this.users = users;
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
	 * @return Se devuelve la lista de objetos de tipo 'List<Comments>'
	 */
	public List<Comments> getListOfComments() {
        return this.listOfComments;
    }
	/**
	 * @param listOfComments<List<CommentsEntity>> - La lista de objetos de tipo 'List<Comments>' a establecer
	 */
	public void setListOfComments( List<Comments> listOfComments ) {
        this.listOfComments = listOfComments;
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
//		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (!(obj instanceof Customers)) {
			return false;
		}
		Customers other = (Customers) obj;
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
		if (users == null) {
			if (other.users != null) {
				return false;
			}
		} else if (!users.equals(other.users)) {
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
		if (!(listOfComments instanceof List)) {
			if (!(other.listOfComments instanceof List)) {
				if (listOfComments == null) {
					if (other.listOfComments != null) {
						return false;
					}
				} else if (!listOfComments.equals(other.listOfComments)) {
					return false;
				}
			}			
		} else if (other.listOfComments != null && !(other.listOfComments instanceof List)) {
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
		if (users != null) {
			builder.append("users=");
			builder.append(users);
			builder.append(", ");
		}		
		if (listOfSubcription != null && !(listOfSubcription instanceof List)) {
			builder.append("listOfSubcription=");
			builder.append(toString(listOfSubcription, maxLen));
			builder.append(", ");
		}		
		if (listOfComments != null && !(listOfComments instanceof List)) {
			builder.append("listOfComments=");
			builder.append(toString(listOfComments, maxLen));
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

