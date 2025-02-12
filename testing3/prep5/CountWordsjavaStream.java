//package mywork;
package prep5;

import java.util.Arrays;

public class CountWordsjavaStream {

	public static void main(String[] args) {
		String str = "DeepakKumar";

		// long x = Arrays.stream(str.split(" ")).count();

		StringBuffer sb = new StringBuffer(str.toString()).reverse();

		char c = Character.toUpperCase(sb.charAt(str.length() - 1));
		// c = (sb.charAt(str.length()-1));
		sb.append(c);
		System.out.println(sb);

	}

}
