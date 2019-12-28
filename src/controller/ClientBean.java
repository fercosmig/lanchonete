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

import model.Client;
import repository.ClientRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file controller.ClientBean.java
 */
@ManagedBean(name = "cli")
@SessionScoped
public class ClientBean implements Serializable, GenericBean {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(ClientBean.class.getName());

	/**
	 * Attributes
	 */
	private List<Client> clients;
	private Client client;
	private int id;
	private ClientRepository cr;

	/**
	 * Constructors
	 */
	public ClientBean() {
		this.clients = new ArrayList<Client>();
		this.client = new Client();
	}

	/**
	 * Methods
	 */

	@Override
	public String create() {
		LOGGER.info("method create");
		cr = new ClientRepository();

		client.setName(client.getName().trim());
		client.setEmail(client.getEmail().trim());
		client.setPhone(client.getPhone().trim());
		client.setNotes(client.getNotes().trim());

		try {
			cr.create(client);
			client = new Client();
			return "clientList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar criar o cliente!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void retrieveById() {
		LOGGER.info("method retrieveById");
		cr = new ClientRepository();
		try {
			this.client = cr.retrieveById(client);
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Cliente não encontrado!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	@Override
	public void retrieveAll() {
		LOGGER.info("method retrieveAll");
		cr = new ClientRepository();
		try {
			this.clients = cr.retrieveAll();
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
		cr = new ClientRepository();

		client.setName(client.getName().trim());
		client.setEmail(client.getEmail().trim());
		client.setPhone(client.getPhone().trim());
		client.setNotes(client.getNotes().trim());

		try {
			cr.update(client);
			client = new Client();
			return "clientList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar atualizar o cliente!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public String delete() {
		LOGGER.info("method delete");
		cr = new ClientRepository();
		try {
			cr.delete(client);
			return "clientList?faces-redirect=true";
		} catch (Exception e) {
			LOGGER.error(e);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Erro ao tentar excluir o cliente!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
	}

	@Override
	public void getNew() {
		this.client = new Client();
	}

	/**
	 * Getters and setters
	 */

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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