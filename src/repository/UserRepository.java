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

import model.User;
import util.ConnectionFactory;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file repository.UserRepository.java
 */
public class UserRepository implements GenericRepository<User> {

	private static final Logger LOGGER = LogManager.getLogger(UserRepository.class.getName());

	/**
	 * Attributes
	 */
	private Connection conn;

	/**
	 * Constructors
	 */
	public UserRepository() {
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
	public void create(User user) throws Exception {
		LOGGER.info("method create: " + user.getName());

		String sql = "INSERT INTO tbUser (login, password, name, email) VALUES (?, MD5(?), ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	@Override
	public User retrieveById(User user) throws Exception {
		LOGGER.info("method retrieveById: " + user.getId());

		String sql = "SELECT id, login, password, name, email, status, registrationDate FROM tbUser WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();

			User u = new User();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setStatus(rs.getBoolean("status"));
				u.setRegistrationDate(rs.getTimestamp("registrationDate"));
			}
			return u;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	public User retrieveByLogin(final User user) throws Exception {
		LOGGER.info("method retrieveByLogin: " + user.getLogin());

		String sql = "SELECT id, login, password, name, email, status, registrationDate FROM tbUser WHERE login = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			rs = ps.executeQuery();

			User u = new User();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setStatus(rs.getBoolean("status"));
				u.setRegistrationDate(rs.getTimestamp("registrationDate"));
			}
			return u;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<User> retrieveAll() throws Exception {
		LOGGER.info("method retrieveAll");

		String sql = "SELECT id, login, password, name, email, status, registrationDate FROM tbUser WHERE status = true ORDER BY name ASC";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		User u = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setStatus(rs.getBoolean("status"));
				u.setRegistrationDate(rs.getTimestamp("registrationDate"));

				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public void update(User user) throws Exception {
		LOGGER.info("method update: " + user.getName());

		String sql = "UPDATE tbUser SET login = ?, password = ?, name = ?, email = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	@Override
	public void delete(User user) throws Exception {
		LOGGER.info("method delete: " + user.getId());

		String sql = "UPDATE tbUser SET status = false WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

}
