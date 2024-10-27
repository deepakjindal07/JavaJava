package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Incrementd {

	public static void main(String[] args) throws IOException {

		//Scanner scan = new Scanner(System.in);
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String temp = scan.readLine();

		int x = Integer.parseInt(temp);


		System.out.println(x);

//		int y = x;
//		System.out.println("Value of x"+x);
//		System.out.println("Value of y"+y);

	}

}
