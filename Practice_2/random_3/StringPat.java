package random_3;

public class StringPat {

	public static void main(String[] args) {
		char ch = 'a';
		int n = 5;

		for (int i = 0; i <= n; i++)
		{

			// System.out.println(ch);

			for (int j = 0; j <= i; j++)
			{
				System.out.print(ch);
			}

			ch += 1;
			System.out.println();
		}
	}

}
