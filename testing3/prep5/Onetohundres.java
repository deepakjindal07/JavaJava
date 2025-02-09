
package prep5;
public class Onetohundres {

	public static void main(String[] args) {

		/*
		 * You can improvise this to use command line arguments
		 *
		 * or java.util.Scanner later on to get input from the
		 *
		 * user.
		 */

		int n = 150;

		// For Loop

		for (int i = 1; i <= n; i++) {

			/*
			 * if a number is divisible by 10 don't print the number
			 *
			 * but continue to next step of loop
			 */

			if (i % 10 == 0) {

				continue;

			}

			// if number is >100 break out of the loop

			if (i > 100) {

				break;

			}

			System.out.println(i);

		}

		// While Loop

		int i = 1;

		while (i <= n) {

			if (i % 10 == 0) {

				i++;

				continue;

			}

			if (i > 100) {

				break;

			}

			System.out.println(i++);

		}

		// do-while

		i = 1;

		do {

			if (i % 10 == 0) {

				i++;

				continue;

			}

			if (i > 100) {

				break;

			}

			System.out.println(i++);

		} while (i <= n);

	}

}