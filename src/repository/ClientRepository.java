/**
 * 
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Client;
import util.ConnectionFactory;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file repository.ClientRepository.java
 */
public class ClientRepository implements GenericRepository<Client> {

	private static final Logger LOGGER = LogManager.getLogger(ClientRepository.class.getName());

	/**
	 * Attributes
	 */
	private Connection conn;

	/**
	 * Constructors
	 */
	public ClientRepository() {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	/**
	 * Methods
	 */
	@Override
	public void create(Client client) throws Exception {
		LOGGER.info("method create: " + client.getName());

		String sql = "INSERT INTO tbClient (name, email, phone, notes) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getEmail());
			ps.setString(3, client.getPhone());
			ps.setString(4, client.getNotes());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	@Override
	public Client retrieveById(Client client) throws Exception {
		LOGGER.info("method retrieveById: " + client.getId());

		String sql = "SELECT id, name, email, phone, notes, status, registrationDate FROM tbClient WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, client.getId());
			rs = ps.executeQuery();

			Client c = new Client();
			while (rs.next()) {
				c = new Client();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setNotes(rs.getString("notes"));
				c.setStatus(rs.getBoolean("status"));
				c.setRegistrationDate(rs.getTimestamp("registrationDate"));
				return c;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Client> retrieveAll() throws Exception {
		LOGGER.info("method retrieveAll");

		String sql = "SELECT id, name, email, phone, notes, status, registrationDate FROM tbClient WHERE status = true ORDER BY name ASC";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> clients = new ArrayList<Client>();
		Client c = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Client();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setNotes(rs.getString("notes"));
				c.setStatus(rs.getBoolean("status"));
				c.setRegistrationDate(rs.getTimestamp("registrationDate"));
				clients.add(c);
			}
			return clients;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public void update(Client client) throws Exception {
		LOGGER.info("method update: " + client.getName());

		String sql = "UPDATE tbClient SET name = ?, email = ?, phone = ?, notes = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getEmail());
			ps.setString(3, client.getPhone());
			ps.setString(4, client.getNotes());
			ps.setInt(5, client.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	@Override
	public void delete(Client client) throws Exception {
		LOGGER.info("method delete: " + client.getId());

		String sql = "UPDATE tbClient SET status = false WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, client.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
