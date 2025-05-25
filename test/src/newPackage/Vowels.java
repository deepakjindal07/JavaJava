package newPackage;

public class Vowels {

	public static void main(String[] args) {
		String str = "This is Testing Environment"; // replace vowels to *, each word in new line.
		String[] strArr = str.split(" ");

		String newstr = "";

		for (String s : strArr)
		{
			char[] ch = s.toCharArray();
			for (char c : ch)
			{
				if ("aeiouAEIOU".indexOf(c) != -1)
				{
					c = '*';
					newstr = newstr + c;
				} else
				{
					newstr = newstr + c;
				}

			}
			newstr = newstr+" ";
			System.out.println(s);
		}
		System.out.println(newstr);

	}

}
