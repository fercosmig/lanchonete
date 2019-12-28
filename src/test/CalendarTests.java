/**
 * 
 */
package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 27, 2019
 * @file test.CalendarTests.java
 */
public class CalendarTests {

	/**
	 * Methods
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime()); // Mon Dec 02 20:34:05 BRT 2019

		String pattern = "EEEEE MMMMM dd, yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(c.getTime())); // Monday December 02, 2019 20:29:49

		pattern = "EEE MMM dd, yyyy HH:mm:ss";
		sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(c.getTime())); // Mon Dec 02, 2019 20:27:55

		pattern = "yyyy-MM-dd HH:mm:ss";
		sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(c.getTime())); // 2019-12-02 20:27:55

		pattern = "dd-MM-yyyy HH:mm:ss";
		sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(c.getTime())); // 02-12-2019 20:30:51

		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(f.format(c.getTime())); // Monday, December 2, 2019

		f = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(f.format(c.getTime())); // December 2, 2019

		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(f.format(c.getTime())); // Dec 2, 2019

		f = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(f.format(c.getTime())); // 12/2/19

	}

}
