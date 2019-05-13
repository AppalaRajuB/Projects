package com.techm.beans;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Appala Raju
 *
 */
@Component
public class User {
	
	private String email;
	
	private String passwd;
	
	private PersonalDetails persons;
	
	/**
	 * @return the persons
	 */
	public PersonalDetails getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(PersonalDetails persons) {
		this.persons = persons;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
