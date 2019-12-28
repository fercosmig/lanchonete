/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

import model.User;
import repository.UserRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.UserList.java
 */
public class UserList {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		UserRepository uc = new UserRepository();
		List<User> la = new ArrayList<User>();
		la = uc.retrieveAll();
		for (User u : la) {
			System.out.println(u.getName());
		}
	}

}
