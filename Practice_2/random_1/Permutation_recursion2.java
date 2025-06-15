package random_1;

public class Permutation_recursion2 {

	public static void main(String[] args) {
		String str = "abc";
		permute(str, "");
	}

	static void permute(String str, String result) {
		if (str.length() == 0)
		{
			System.out.println(result);
			return;
		}

		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			String remaining = str.substring(0, i) + str.substring(i + 1);
			System.out.println("Current remain: "+remaining);
			System.out.println("Current After: "+str.substring(i + 1));
			permute(remaining, result + ch);
		}
	}

}
