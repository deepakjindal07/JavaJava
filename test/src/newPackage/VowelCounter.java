package newPackage;

public class VowelCounter {

	public static void main(String[] args) {
		String str = "Hello programming world";

		int vowel = 0;
		int constant = 0;

		if ("aeiouAEIOU".indexOf(str) != -1)
		{
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

//		for (char c : str.toCharArray())
//		{
//			if ("aeiou".indexOf(c) != -1)
//			{
//				vowel++;
//			} else
//			{
//				constant++;
//			}
//		}

		//System.out.println("Vowel " + vowel + " Cons: " + constant);

	}

}
