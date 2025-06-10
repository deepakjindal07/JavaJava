package random_7;

public class Factorially {

	static int sum = 0;

	public static void main(String[] args) {
		// The factorial of 5 is 5 x 4 x 3 x 2 x 1 = 120
		int n = 1;
		int m = 10;

		sum = 0;
		sumNumbersNORETURN(m);

		// System.out.println(sumNumbers(m));
		System.out.println("Tot" + sum);

	}

	private static int sumNumbers(int m) {
		if (m == 0)
		{
			return 0;
		}

		// sum
		return m += sumNumbers(m - 1);

	}

	private static void sumNumbersNORETURN(int m) {
		if (m == 0)
		{
			return;
		}

		sum +=  m;
		sumNumbersNORETURN(m-1);

	}

	private static void printNumbers(int n) {
		if (n == 10)
		{ // Base case
			return;
		}
		System.out.println(n); // Print before the recursive call
		printNumbers(n + 1); // Recursive call
	}
}
