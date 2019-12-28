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

import model.Product;
import util.ConnectionFactory;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file repository.ProductRepository.java
 */
public class ProductRepository implements GenericRepository<Product> {

	private static final Logger LOGGER = LogManager.getLogger(ProductRepository.class.getName());

	/**
	 * Attributes
	 */
	private Connection conn;

	/**
	 * Constructors
	 */
	public ProductRepository() {
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
	public void create(Product product) throws Exception {
		LOGGER.info("method createProduct: " + product.getDescription());

		String sql = "INSERT INTO tbProduct (description, unit, cost, price) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getDescription());
			ps.setString(2, product.getUnit());
			ps.setDouble(3, product.getCost());
			ps.setDouble(4, product.getPrice());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	@Override
	public Product retrieveById(Product product) throws Exception {
		LOGGER.info("method retrieveById: " + product.getId());

		String sql = "SELECT id, description, unit, cost, price, status, registrationDate FROM tbProduct WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getId());
			rs = ps.executeQuery();

			Product p = new Product();
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setUnit(rs.getString("unit"));
				p.setCost(rs.getDouble("cost"));
				p.setPrice(rs.getDouble("price"));
				p.setStatus(rs.getBoolean("status"));
				p.setRegistrationDate(rs.getTimestamp("registrationDate"));
			}
			return p;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Product> retrieveAll() throws Exception {
		LOGGER.info("method allProducts");

		String sql = "SELECT id, description, unit, cost, price, status, registrationDate FROM tbProduct WHERE status = true ORDER BY description ASC";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		Product p = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setUnit(rs.getString("unit"));
				p.setCost(rs.getDouble("cost"));
				p.setPrice(rs.getDouble("price"));
				p.setStatus(rs.getBoolean("status"));
				p.setRegistrationDate(rs.getTimestamp("registrationDate"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public void update(Product product) throws Exception {
		LOGGER.info("method update: " + product.getId());

		String sql = "UPDATE tbProduct SET description = ?, unit = ?, cost = ?, price = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getDescription());
			ps.setString(2, product.getUnit());
			ps.setDouble(3, product.getCost());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	@Override
	public void delete(Product product) throws Exception {
		LOGGER.info("method delete: " + product.getId());

		String sql = "UPDATE tbProduct SET status = false WHERE id = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.conn;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

}
