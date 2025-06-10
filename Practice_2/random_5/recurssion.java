package random_5;

public class recurssion {

	public static void main(String[] args) {
		int x = 5;
		int result = factorial(x);
		System.out.println(result);

	}

	public static int factorial(int x) {
		if (x <= 1) {
			return 1;
		} else
			System.out.println("val: " + x);
		return x * factorial(x - 1);

	}
	
}
