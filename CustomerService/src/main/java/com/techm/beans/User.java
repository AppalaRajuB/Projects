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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	@SequenceGenerator(name="customer_generator", sequenceName = "customerseq")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "EMAILID")
	//@Pattern(regexp ="^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$", message="Please enter valid email address.")
	@Email
	private String email;
	
	@Column(name = "PSWD")
	@Pattern(regexp="^(?=.{1,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?\\W).*$", message="Password should be minimum 8 charaters length and must contain special symbol, lower and upper case.")  
	private String passwd;
	
	@JoinColumn(name = "PERSON_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private PersonDetails persons;
	
	private transient String charttype;
	
	
	/**
	 * @return the charttype
	 */
	public String getCharttype() {
		return charttype;
	}

	/**
	 * @param charttype the charttype to set
	 */
	public void setCharttype(String charttype) {
		this.charttype = charttype;
	}

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
