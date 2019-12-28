/**
 * 
 */
package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.ConnectionFactory;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.ResultsetTest.java
 */
public class ResultsetTest {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setId(2);

		String sql = "SELECT id, login, password, name, email, status, registrationDate FROM tbUser WHERE id = ?";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ResultSet rs = ps.executeQuery();

		System.out.println("rs.next() = " + rs.next());
		rs.beforeFirst();

		while (rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setLogin(rs.getString("login"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getNString("email"));
			u.setStatus(rs.getBoolean("status"));
			u.setRegistrationDate(rs.getTimestamp("registrationDate"));
			System.out.println(rs.getRow());
			System.out.println(rs.getFetchSize());
			System.out.println(u.getName());
		}
		ConnectionFactory.closeConnection(conn, ps, rs);
	}

}
