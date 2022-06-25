package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	public static final String ID_CUSTOMER = "idCustomer"; 
	public static final String FIRST_NAME = "firstName"; 
	public static final String LAST_NAME = "lastName"; 
	public static final String EMAIL = "email"; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idCustomer;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	public Customer() {
	}

	public Customer(Integer idCustomer, String firstName, String lastName, String email) {
		super();
		this.idCustomer = idCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}
	
	
	
}
