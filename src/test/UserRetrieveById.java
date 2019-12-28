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
 * @file test.UserRetrieveById.java
 */
public class UserRetrieveById {

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

		UserRepository uc = new UserRepository();
		u = uc.retrieveById(u);

		System.out.println(u.getId());
		System.out.println(u.getLogin());
		System.out.println(u.getPassword());
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		System.out.println(u.getStatus());
		System.out.println(u.getRegistrationDate());
	}

}
