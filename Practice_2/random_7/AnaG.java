package random_7;

import java.util.Arrays;

public class AnaG {

	public static void main(String[] args) {
		String first = "Silent";
		String second = "ListEdn";

		char[] cfirst = first.toLowerCase().toCharArray();
		char[] csecond = second.toLowerCase().toCharArray();

		Arrays.sort(cfirst);
		Arrays.sort(csecond);

//		if (Arrays.equals(cfirst, csecond))
//		{
//			System.out.println("True");
//		} else
//		{
//			System.out.println("not");
//		}

		System.out.println(Arrays.equals(cfirst, csecond) ? "True" : "NotAnalg");

	}

}
