/**
 * 
 */
package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Jan 11, 2020
 * @file controller.SaleProductBean.java
 */
@ManagedBean(name = "sprod")
@SessionScoped
public class SaleProductBean implements Serializable, GenericBean{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(SaleProductBean.class.getName());

	/**
	 * Constructors
	 */
	public SaleProductBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methods
	 */
	
	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retrieveById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retrieveAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getNew() {
		// TODO Auto-generated method stub
		
	}

}
