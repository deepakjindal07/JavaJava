package prep5;

public class SumofNumfromString {

	public static void main(String[] args) {
		String str = "1234 hello world";

		char[] ch = str.toCharArray();

		int temp = 0;
		for (char c : ch)
		{
			if (c >= '1' && c <= '9')
			{
				System.out.println("Is a number");
				temp += c - '0';
				Integer.parseInt(String.valueOf(c));
			}


		}
		System.out.println("Total: " + temp);

	}

}
