// these all the basic java programs come under beginner level
package basics;

public class leap_year_again {

	public static void main(String[] args) {

		// year to be checked
		int year = 1900;
		boolean leap = false;

		// if the year is divided by 4
		if (year % 4 == 0) {

			// if the year is century
			if (year % 100 == 0) {

				// if year is divided by 400
				// then it is a leap year
				if (year % 400 == 0) {
					leap = true;
				} else {
					leap = false;
				}
			} else {
				leap = true;
			}
		} else {
			leap = false;
		}

		if (leap) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}
}
