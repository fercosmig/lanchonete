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
 * @file test.UserUpdate.java
 */
public class UserUpdate {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setId(1);

		UserRepository uc1 = new UserRepository();
		u = uc1.retrieveById(u);

		u.setName("Jurandir Migliorini");
		u.setEmail("j.migliorini@gmail.com");

		UserRepository uc2 = new UserRepository();
		uc2.update(u);

		UserRepository uc3 = new UserRepository();
		u = uc3.retrieveById(u);

		System.out.println(u.getId());
		System.out.println(u.getLogin());
		System.out.println(u.getPassword());
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		System.out.println(u.getStatus());
		System.out.println(u.getRegistrationDate());
	}

}
