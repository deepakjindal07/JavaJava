//package mywork;
package temp;

import java.util.Arrays;

public class CountWordsjavaStream {

	public static void main(String[] args) {
		String str = "I am learning java";

		long x = Arrays.stream(str.split(" ")).count();



		System.out.println(x);

	}

}
