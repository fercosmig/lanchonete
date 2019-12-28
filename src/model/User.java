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
 * @file model.User.java
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */
	private Integer id;
	private String login;
	private String password;
	private String name;
	private String email;
	private Boolean status;
	private Date registrationDate;

	/**
	 * Constructors
	 */
	public User() {
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param name
	 * @param email
	 * @param status
	 * @param registrationDate
	 */
	public User(Integer id, String login, String password, String name, String email, Boolean status,
			Date registrationDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
