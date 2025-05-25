package newPackage;

public class Fact {

	public static void main(String[] args) {
		{
			int s = 5;

			// Iterative approach
			int temp = 1;
			for (int i = 1; i <= s; i++)
			{
				temp = temp * i;
			}
			System.out.println("Iterative: " + temp);

			// Recursive approach
			System.out.println("Recursive: " + recursion(s));
		}
	}

	private static int recursion(int s) {
		if (s == 0 || s == 1)
		{
			return 1; // Base case
		}
		return s * recursion(s - 1); // Recursive step

	}
}
