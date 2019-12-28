/**
 * 
 */
package test;

import enumeration.Units;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.EnumTest.java
 */
public class EnumTest {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Units a : Units.values()) {
			System.out.println(a);
		}
		System.out.println(Units.values());
	}

}
