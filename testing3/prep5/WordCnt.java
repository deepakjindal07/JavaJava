package prep5;

public class WordCnt {

	public static void main(String[] args) {
		String test = "inndddia";
		// in2d3i2a;

		char[] ch = test.toCharArray();

		for (int i = 0; i < test.length(); i++)
		{
			int temp = 0;
			int count = 0;
			for (int j = 0; j < test.length(); j++)
			{

				if (ch[i] == ch[j])
				{
					// System.out.println("True");
					temp++;

					// System.out.println(count);
				}

			}

			System.out.println("Word: " + ch[i] + " " + temp);
		}
//		if (count > 0)
//		{
//			
//		}

	}

}
