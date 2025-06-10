package random_4;

public class Duplicate {

	public static void main(String[] args) {
		// How to Find Duplicate Elements in an Array

		int[] arr = { 1, 2, 6, 3, 3, 4, 5 };
		int l = arr.length;

		// Arrays.sort(arr);

		for (int a = 0; a < l; a++) {
			for (int b = a+1; b < l; b++) {

				if (arr[a] == arr[b]) {
					System.out.println("Dup"+arr[a]);
				}
			}
		}

	}

}
