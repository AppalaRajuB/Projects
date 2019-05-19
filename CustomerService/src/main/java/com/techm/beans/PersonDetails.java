package com.techm.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PERSONAL_DETAILS")
public class PersonDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
	@SequenceGenerator(name="person_generator", sequenceName = "customerseq")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "PERSON_ID")
	private Long id;
	
	@Column(name = "USERNAME")	
	@NotBlank(message="Please enter name.")
	@NotEmpty(message="")
	private String name;
	
	@Column(name = "GENDER")
	@NotEmpty(message="Please select gender.")
	private String gender;
	
	@NotEmpty(message="Please select dateofBirth.")
	private transient String dateofBirth; 
	
	@Column(name = "DOB")
	private Timestamp dob;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "FILEPATH")
	private String filepath;
	
	@Column(name = "CREATEDATE")
	private Timestamp createdDate;
	
	@Column(name = "UPDATEDATE")
	private Timestamp updateDate;
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}


	/**
	 * @return the dob
	 */
	public Timestamp getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Timestamp dob) {
			this.dob = dob;
		
	}

	/**
	 * @return the dateofBirth
	 */
	public String getDateofBirth() {
		
		if(getDob() == null)
		{
			return dateofBirth;
		}else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			return formatter.format(getDob());
		}
	}

	/**
	 * @param dateofBirth the dateofBirth to set
	 */
	public void setDateofBirth(String dateofBirth) {
		if(getDob() == null)
		{
			this.dateofBirth = dateofBirth;
			try
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			    Date parsedTimeStamp = dateFormat.parse(getDateofBirth());
			    this.dob = new Timestamp(parsedTimeStamp.getTime());
			}catch(Exception ex)
			{
				
			}
		}else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			this.dateofBirth = formatter.format(getDob());
			
		}
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

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
