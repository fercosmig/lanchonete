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
 * @file model.SaleProduct.java
 */
public class SaleProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */
	Integer id;
	Integer saleId;
	Integer productId;
	Double quantity;
	Double unitValue;
	Double totalValue;
	private Boolean status;
	private Date registrationDate;

	/**
	 * Costructors
	 */
	public SaleProduct() {
	}

	/**
	 * @param id
	 * @param saleId
	 * @param productId
	 * @param quantity
	 * @param unitValue
	 * @param totalValue
	 * @param status
	 * @param registrationDate
	 */
	public SaleProduct(Integer id, Integer saleId, Integer productId, Double quantity, Double unitValue,
			Double totalValue, Boolean status, Date registrationDate) {
		super();
		this.id = id;
		this.saleId = saleId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
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
	 * @return the saleId
	 */
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitValue
	 */
	public Double getUnitValue() {
		return unitValue;
	}

	/**
	 * @param unitValue the unitValue to set
	 */
	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}

	/**
	 * @return the totalValue
	 */
	public Double getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
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
