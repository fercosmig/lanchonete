/**
 * 
 */
package enumeration;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file enumeration.Units.java
 */
public enum Units {

	CP("Copo"), DS("Dose"), GR("Garrafa"), LT("Lata"), L("Litro"), PR("Porção"), UN("Unidade");

	/**
	 * Attributes
	 */
	private String description;

	/**
	 * Constructors
	 */

	/**
	 * @param description
	 */
	private Units(String description) {
		this.description = description;
	}

	/**
	 * Getters and Setters
	 */

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}