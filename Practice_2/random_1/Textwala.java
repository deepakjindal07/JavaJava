package random_1;

public class Textwala {

	public static void main(String[] args) {

		String str = "1234567"; // get sum of last 3 digits.
		// int i = Integer.valueOf(str);

		int fin = 0;
		int Slen = str.length() - 3;
		int len = str.length() ;
		String newStr = str.substring(Slen, len);

		for (char c : newStr.toCharArray())
		{

			// if()
			fin = fin + Character.getNumericValue(c);

		}

		System.out.println(fin);

	}
}
