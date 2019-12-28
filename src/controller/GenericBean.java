/**
 * 
 */
package controller;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file controller.GenericBean.java
 */
public interface GenericBean {

	public String create();

	public void retrieveById();

	public void retrieveAll();

	public String update();

	public String delete();

	public void getNew();
}
