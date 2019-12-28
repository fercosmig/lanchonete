/**
 * 
 */
package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.User;
import repository.UserRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.UserCreate.java
 */
public class UserCreate {

	private static final Logger LOGGER = LogManager.getLogger(UserCreate.class.getName());

	/**
	 * Methods
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User u = new User();
		u.setLogin("amascarenhas");
		u.setPassword("123456");
		u.setName("Angela Mascarenhas");
		u.setEmail("a.mascarenhas@gmail.com");

		try {
			UserRepository uc = new UserRepository();
			uc.create(u);
			LOGGER.info("Usuário " + u.getName() + " Cadastrado com sucesso!");
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

}
