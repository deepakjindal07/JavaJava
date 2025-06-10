package empty;

public class gg {

	public static void main(String[] args) {

		int ans = printNumber(1);
		System.out.println(ans);

	}

	private static int printNumber(int x) {
		if (x == 15)
		{
			return 15;
		}
			System.out.println(x);
		return (printNumber(x+1)); 

	}

}
