/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import repository.ProductRepository;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.ProductList.java
 */
public class ProductList {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ProductRepository pc = new ProductRepository();
		List<Product> la = new ArrayList<Product>();
		la = pc.retrieveAll();
		for (Product p : la) {
			System.out.println(p.getDescription());
		}

	}

}
