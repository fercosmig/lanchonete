/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file model.Client.java
 */
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String notes;
	private Boolean status;
	private Date registrationDate;

	/**
	 * Constructors
	 */
	public Client() {
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param notes
	 * @param status
	 * @param registrationDate
	 */
	public Client(Integer id, String name, String email, String phone, String notes, Boolean status,
			Date registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
		this.status = status;
		this.registrationDate = registrationDate;
	}

	/**
	 * Getters and Setters
	 */
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
