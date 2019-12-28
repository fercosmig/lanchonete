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
 * @file model.Sale.java
 */
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */
	Integer id;
	Integer clientId;
	Double amount;
	Double amountPaid;
	private Boolean status;
	private Date registrationDate;

	/**
	 * Constructors
	 */
	public Sale() {
	}

	/**
	 * @param id
	 * @param clientId
	 * @param amount
	 * @param amountPaid
	 * @param status
	 * @param registrationDate
	 */
	public Sale(Integer id, Integer clientId, Double amount, Double amountPaid, Boolean status, Date registrationDate) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.amount = amount;
		this.amountPaid = amountPaid;
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
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountPaid
	 */
	public Double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
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
