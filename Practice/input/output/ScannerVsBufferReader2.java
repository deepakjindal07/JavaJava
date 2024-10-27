package input.output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScannerVsBufferReader2 {

	public static void main(String[] args) throws IOException {

		BufferedReader temp = new BufferedReader(new InputStreamReader(System.in));
		String x = temp.readLine();

		StringBuilder pop = new StringBuilder(x);

		System.out.println(pop.reverse().toString());

		pop.lastIndexOf(x);

		String tempCaps = pop.substring(5).toUpperCase();

		System.out.println(pop.replace(0, pop.lastIndexOf(x), tempCaps));




		//System.out.println(converter(x));
		//String temp5 = converter(x);
		//System.out.println(changer(temp5));

	}

	public static String converter(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	public static StringBuilder changer(String str) {
		StringBuilder sb = new StringBuilder(str);

		int lenght = sb.length() - 1;

		String Upper = sb.substring(sb.length() - 2).toUpperCase();

		return sb.replace(lenght, lenght, Upper);
	}
}

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter an integer: ");
//		int a = Integer.parseInt(br.readLine());
//
//		System.out.println("Enter a String: ");
//		String b = br.readLine();
//
//		System.out.println("You have entered integer: " + a + " and name: " + b);
