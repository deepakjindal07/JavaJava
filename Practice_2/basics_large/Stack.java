package basics_large;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Nightwemet {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt(); // Number of test cases

		// Iterate through each test case
		for (int t = 0; t < testCases; t++) {
			int N = sc.nextInt(); // Number of elements in the array
			int arr[] = new int[N];

			// Input the array elements
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Solution1 ob = new Solution1();
			int ans = ob.minSubset(arr, N); // Get the result from the Solution class
			System.out.println(ans); // Print the result
		}
	}
}

class Solution1 {

	int minSubset(int[] Arr, int N) {

		long sum = 0;

		// Calculate the sum of all array elements
		for (int element : Arr) {
			sum += element;
		}

		Arrays.sort(Arr); // Sort the array in ascending order

		long curr = 0; // Initialize the current sum
		int cnt = 0; // Initialize the count of elements

		// Iterate through the array from the largest element
		for (int j = Arr.length - 1; j >= 0; j--) {

			curr += Arr[j]; // Add the current element to the current sum

			// If the current sum is greater than the sum of remaining elements
			if (curr > (sum - curr))
			 {
				break; // Exit the loop
			}

			cnt++; // Increment the count of elements
		}

		return cnt + 1; // Return the count of elements in the minimum subset
	}
}
