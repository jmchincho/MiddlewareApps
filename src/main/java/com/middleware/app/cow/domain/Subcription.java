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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * <p>Class Subcription.java.</p>
 * <b>Project:</b><p>Capitan Oferta Web</p>
 * @version 1.0, 6 mar 2017 ( Hora: 21:18:22 ).
 * @author jmchincho
 * Clase de persistencia para la entidad almacenada en la tabla "Subcription"
 */
@Entity
@Table(name="Subcription")
// Definir consultas con nombre aquí
@NamedQueries ( {
  @NamedQuery ( name="Subcription.findAll", query="SELECT x FROM Subcription x" ),
  @NamedQuery ( name="Subcription.countAll", query="SELECT COUNT(x) FROM Subcription x" )
} )
public class Subcription extends AbstractManaged implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * Clave primaria de la entidad  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cow_generator_SubcriptionEntity")
	@SequenceGenerator(name = "cow_generator_SubcriptionEntity", sequenceName = "sq_Subcription", alLocationize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


    /**
	 * Campos de datos de la entidad  
	 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date createDate;


    /**
	 * Enlaces con otras entidades (Relaciones) 
	 */
    @ManyToOne
    @JoinColumn(name="Customer_id", referencedColumnName="id")
    private Customer Customer;
	
    @ManyToOne
    @JoinColumn(name="Company_id", referencedColumnName="id")
    private Company Company;
	


    /**
	 * Constructor(es)
	 */
    /**
	 * Constructor por defecto
	 */
	public Subcription() {
		super();
    }

	/**
	 * Constructor de la superclase
	 */
	public Subcription(Long id) {
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
	 * Getters & Setters para las relaciones
	 */
	/**
	 * @return Se devuelve la lista de objetos de tipo 'Customer'
	 */
	public Customer getCustomer() {
        return this.Customer;
    }
	/**
	 * @param Customer<Customer> - La lista de objetos de tipo 'Customer' a establecer
	 */
	public void setCustomer( Customer Customer ) {
        this.Customer = Customer;
    }

	/**
	 * @return Se devuelve la lista de objetos de tipo 'Company'
	 */
	public Company getCompany() {
        return this.Company;
    }
	/**
	 * @param Company<Company> - La lista de objetos de tipo 'Company' a establecer
	 */
	public void setCompany( Company Company ) {
        this.Company = Company;
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
    	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((Customer == null) ? 0 : Customer.hashCode());
		result = prime * result + ((Company == null) ? 0 : Company.hashCode());
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
		if (!(obj instanceof Subcription)) {
			return false;
		}
		Subcription other = (Subcription) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
			return false;
		}
		if (Customer == null) {
			if (other.Customer != null) {
				return false;
			}
		} else if (!Customer.equals(other.Customer)) {
			return false;
		}
		if (Company == null) {
			if (other.Company != null) {
				return false;
			}
		} else if (!Company.equals(other.Company)) {
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
		if (createDate != null) {
			builder.append("createDate=");
			builder.append(createDate);
			builder.append(", ");
		}		
		if (Customer != null) {
			builder.append("Customer=");
			builder.append(Customer);
			builder.append(", ");
		}		
		if (Company != null) {
			builder.append("Company=");
			builder.append(Company);
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

