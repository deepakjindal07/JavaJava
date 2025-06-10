package random_1;

public class FNR {

	public static void main(String[] args) {

		int times = 18; // 1,2,3,5,8,13
		int first = 0;
		int second = 1;
		int temp;

		for (int i = 1; i <= times; i++)
		{
			System.out.println(first);
			temp = first;
			first = second;
			second = temp + second;

			//System.out.println(temp);

		}

	}
}

//			char[] ch = s.toCharArray();
//
//			for (int i = s.length()-1; i >= 0; i--)
//			{
//				System.out.print(ch[i]);
//			}
//			System.out.println();