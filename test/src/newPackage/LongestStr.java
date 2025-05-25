package newPackage;

public class LongestStr {

	public static void main(String[] args) {
		String str = "Java is super fast";

		String[] str2 = str.split(" ");

		int max = 0;
		String final1 = "";

		for (String s : str2)
		{
			if (s.length() > max)
			{
				max = s.length();
				final1 = s;
			}
		}
		System.out.println(final1 + " max word " + max);

	}

}
