/**
 * 
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Product;
import repository.ProductRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file controller.ProductBean.java
 */
@ManagedBean(name = "prod")
@SessionScoped
public class ProductBean implements Serializable, GenericBean {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(ProductBean.class.getName());

	/**
	 * Attributes
	 */
	private List<Product> products;
	private Product product;
	private int id;
	private ProductRepository pr;

	/**
	 * Constructors
	 */
	public ProductBean() {
		this.products = new ArrayList<Product>();
		this.product = new Product();
	}

	/**
	 * Methods
	 */
	@Override
	public String create() {
		LOGGER.info("method create");

		pr = new ProductRepository();
		product.setDescription(product.getDescription().trim());

		try {
			pr.create(product);
			product = new Product();
			return "productList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar criar o produto!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void retrieveById() {
		LOGGER.info("method retrieveById");
		pr = new ProductRepository();
		try {
			this.product = pr.retrieveById(product);
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Produto não encontrado!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	@Override
	public void retrieveAll() {
		LOGGER.info("method retrieveAll");
		pr = new ProductRepository();
		try {
			this.products = pr.retrieveAll();
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Nenhum registro encontrado no banco de dados!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	@Override
	public String update() {
		LOGGER.info("method update");
		pr = new ProductRepository();
		product.setDescription(product.getDescription().trim());
		try {
			pr.update(product);
			product = new Product();
			return "productList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar atualizar o produto!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public String delete() {
		LOGGER.info("method delete");
		pr = new ProductRepository();
		try {
			pr.delete(product);
			return "productList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar excluir o produto!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void getNew() {
		this.product = new Product();
	}

	/**
	 * Getters and Setters
	 */

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
