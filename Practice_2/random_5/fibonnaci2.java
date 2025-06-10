package random_5;

class fibonnaci2 {

	public static void main(String[] args) {
		int n = 10; // Number of terms in the Fibonacci sequence
		fibnoRecursion(0, 1, n); // Output: 0 1 1 2 3 5 8 13 21 34
	}

	static void fibnoRecursion(int firstnum, int secondnum, int n) {
		if (n <= 0)
		{
			return; // Base case: stop when no more terms are needed
		}
		System.out.print(firstnum + " "); // Print the current Fibonacci number
		fibnoRecursion(secondnum, firstnum + secondnum, n - 1); // Recursive call for the next term
	}
}