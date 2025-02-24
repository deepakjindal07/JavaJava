package interview;

public class OutPuty {

	public static void main(String[] args) {
		String str = "H2O[2]"; // H2O2

		char[] ch = str.toCharArray();

//		for (char c : ch)
//		{
//			if (c != '[' && c != ']')
//			{
//				System.out.print(c);
//			}
//
//		}

		StringBuilder str2 = new StringBuilder();

		for (int i = 0; i < str.length()-2; i++)
		{
			if (str.charAt(i) != '[' && str.charAt(i) != ']')
			{
				// System.out.print(str.charAt(i));

				str2.append(str.charAt(i));
				// String.valueOf(c);

				;
			}
		}

		System.out.println(str2.toString());

	}

}
