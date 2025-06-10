package random_7;

public class Vovwel {

	public static void main(String[] args) {
		String str = "AEIORxxuuoo";
		char[] ch = str.toLowerCase().toCharArray();

		for (int i = 0; i < str.length(); i++)
		{
			if ("aeiou".indexOf(ch[i]) != -1)
			{
				System.out.println("Vowel Found: " + ch[i]);
			} else
				System.out.println("Constant Found: " + ch[i]);
		}

	}

}
