/**
 * 
 */
package test;

import model.User;
import repository.UserRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.UserLogin.java
 */
public class UserLogin {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		boolean isLogged = false;
		User u1 = new User();
		UserRepository uc1 = new UserRepository();

		u1.setLogin("fercosmig");
		u1.setPassword("fercosmig");
		u1 = uc1.retrieveByLogin(u1);
		if (isLogged) {
			UserRepository uc2 = new UserRepository();
			u1 = uc2.retrieveByLogin(u1);
		}
		System.out.println(u1.getName());
	}

}
