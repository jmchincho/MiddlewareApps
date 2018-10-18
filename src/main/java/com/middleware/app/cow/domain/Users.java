// This Bean has a basic Primary Key (not composite) 

package com.middleware.app.cow.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Class User.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "User"
 */
@Entity
@Table(name="User")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="User.findAll", query="SELECT x FROM User x" ),
  @NamedQuery ( name="User.countAll", query="SELECT COUNT(x) FROM User x" )
} )
public class User extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_UserEntity")
	@SequenceGenerator(name = "cow_generator_UserEntity", sequenceName = "sq_User", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Column(name="username", nullable=false, length=100)
    private String username;

    @Column(name="password", nullable=false, length=255)
    private String password;

    @Column(name="mail", nullable=false, length=100)
    private String mail;

    @Column(name="state", nullable=false, length=1)
    private String state;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName="id")
    private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id", referencedColumnName="id")
    private Company company;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="administrator_id", referencedColumnName="id")
    private Administrator administrator;
	
	@JsonIgnore
    @OneToMany(mappedBy="User", targetEntity=Address.class)
    private List<Address> addresses;
	
	@JsonIgnore
    @OneToMany(mappedBy="User", targetEntity=Order.class)
    private List<Order> Order;
	
    

    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public User() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public User(Long id) {
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
	 * @return Se devuelve el campo 'username'
	 */
	public String getUsername() {
        return this.username;
    }
	/**
	 * @param username<String> - El campo 'username' a establecer
	 */
	public void setUsername( String username ) {
        this.username = username;
    }

	/**
	 * @return Se devuelve el campo 'password'
	 */
	public String getPassword() {
        return this.password;
    }
	/**
	 * @param password<String> - El campo 'password' a establecer
	 */
	public void setPassword( String password ) {
        this.password = password;
    }

	/**
	 * @return Se devuelve el campo 'mail'
	 */
	public String getMail() {
        return this.mail;
    }
	/**
	 * @param mail<String> - El campo 'mail' a establecer
	 */
	public void setMail( String mail ) {
        this.mail = mail;
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
	 * Get customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Set customer.
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Get company.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return this.company;
	}

	/**
	 * Set company.
	 *
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Get administrator.
	 *
	 * @return the administrator
	 */
	public Administrator getAdministrator() {
		return this.administrator;
	}

	/**
	 * Set administrator.
	 *
	 * @param administrator the administrator to set
	 */
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
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
    	result = prime * result + ((username == null) ? 0 : username.hashCode());
    	result = prime * result + ((password == null) ? 0 : password.hashCode());
    	result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    	result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (mail == null) {
			if (other.mail != null) {
				return false;
			}
		} else if (!mail.equals(other.mail)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (!(addresses instanceof List)) {
			if (!(other.addresses instanceof List)) {
				if (addresses == null) {
					if (other.addresses != null) {
						return false;
					}
				} else if (!addresses.equals(other.addresses)) {
					return false;
				}
			}			
		} else if (other.addresses != null && !(other.addresses instanceof List)) {
			return false;
		}
		if (!(Order instanceof List)) {
			if (!(other.Order instanceof List)) {
				if (Order == null) {
					if (other.Order != null) {
						return false;
					}
				} else if (!Order.equals(other.Order)) {
					return false;
				}
			}			
		} else if (other.Order != null && !(other.Order instanceof List)) {
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
		if (username != null) {
			builder.append("username=");
			builder.append(username);
			builder.append(", ");
		}		
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}		
		if (mail != null) {
			builder.append("mail=");
			builder.append(mail);
			builder.append(", ");
		}		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}	
		if (addresses != null && !(addresses instanceof List)) {
			builder.append("addresses=");
			builder.append(toString(addresses, maxLen));
			builder.append(", ");
		}		
		if (Order != null && !(Order instanceof List)) {
			builder.append("Order=");
			builder.append(toString(Order, maxLen));
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

