// these all the basic java programs come under beginner level
package basics_large;

public class AbsoluteValueCalculator {
	public static void main(String args[]) {
		int i, k;
		i = 10;
		k = i < 0 ? -i : i;// get absolute value of i
		System.out.println("Absolute value of");
		System.out.println(i + "is" + k);
		i = -10;
		k = i < 0 ? -i : i;// get absolute value of i
		System.out.println("Absolute value of");
		System.out.println(i + "is" + k);
	}
}
