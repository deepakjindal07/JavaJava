package pack3;

public class facrR {
	static String s ="5";
	static int F = Integer.parseInt(s);

	public static void main(String[] args) {

		
		findFact(F);

	}

	private static void findFact(int f) {

		int result = 1;
		for (int i = 1; i <= F; i++)
		{
			result = result * i;
			System.out.println(result);
		}

		System.out.println("Final "+result);

	}

}
