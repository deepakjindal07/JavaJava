//package mywork;
package prep5;

import java.util.Arrays;

public class CountWordsjavaStream {

	public static void main(String[] args) {
		String str = "DeepakKumar";

		// long x = Arrays.stream(str.split(" ")).count();

		StringBuffer sb = new StringBuffer(str.toString()).reverse();

		Character.toUpperCase(sb.charAt(str.length() - 1));

		char c;
		c = (sb.charAt(str.length()-1)); 
		sb.append(sb.charAt(str.length()),"8");
		System.out.println(sb);

	}

}
