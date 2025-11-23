package seleniumTest;


public class test {

	public static void main(String[] args) {
		String w = "Deloitte";
		char[] wChar = w.toCharArray();
		int count = 0;

		for (int i = 0; i <= wChar.length; i++)
		{
			for (int j = i + 1; j <= wChar.length - 1; j++)
			{
				if (wChar[i] == wChar[j])
				{
					count++;
					System.out.println(wChar[j]);// + " Count: " + count);

				}

			}
		}
	}
}
