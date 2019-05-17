package com.techm.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Appala Raju
 *
 */

@Entity
@Table(name = "Login")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "EMAILID")
	private String email;
	
	@Column(name = "PSWD")
	private String passwd;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID")
	private PersonDetails persons;
	
	
	/**
	 * @return the persons
	 */
	public PersonDetails getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(PersonDetails persons) {
		this.persons = persons;
	}

	/**
	 * @return the id
	 */
	
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name = "EMAILID")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
