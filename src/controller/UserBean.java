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

import model.User;
import repository.UserRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file controller.UserBean.java
 */
@ManagedBean(name = "usr")
@SessionScoped
public class UserBean implements Serializable, GenericBean {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(UserBean.class.getName());

	/**
	 * Attributes
	 */
	private List<User> users;
	private User user;
	private int id;
	private UserRepository ur;

	/**
	 * Constructors
	 */
	public UserBean() {
		this.users = new ArrayList<User>();
		this.user = new User();
	}

	/**
	 * Methods
	 */
	@Override
	public String create() {
		LOGGER.info("create: " + user.getName());

		String login = user.getLogin().trim();
		String pwd = user.getPassword().trim();
		String name = user.getName().trim();
		String email = user.getEmail().trim();

		user.setLogin(login);
		user.setPassword(pwd);
		user.setName(name);
		user.setEmail(email);

		ur = new UserRepository();
		try {
			ur.create(user);
			user = new User();
			return "userList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar criar o usuário!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void retrieveById() {
		LOGGER.info("method retrieveById");
		ur = new UserRepository();
		try {
			this.user = ur.retrieveById(user);
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Usuário não encontrado!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	@Override
	public void retrieveAll() {
		LOGGER.info("method retrieveAll");
		ur = new UserRepository();
		try {
			this.users = ur.retrieveAll();
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("0 registros!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	@Override
	public String update() {
		LOGGER.info("method update");

		String login = user.getLogin().trim();
		String name = user.getName().trim();
		String email = user.getEmail().trim();

		user.setLogin(login);
		user.setName(name);
		user.setEmail(email);

		ur = new UserRepository();
		try {
			ur.update(user);
			user = new User();
			return "userList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar atualizar o usuário!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public String delete() {
		LOGGER.info("method delete");

		ur = new UserRepository();
		try {
			ur.delete(user);
			return "userList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar excluir o usuário!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void getNew() {
		this.user = new User();
	}

	/**
	 * Getters and Setters
	 */

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
