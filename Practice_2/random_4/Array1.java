package random_4;

public class Array1 {

	public void main(String[] args) {
		// Find the Minimum and Maximum values in an Array

		int[] arr = { 6, 2, 3, 6, 5, 4 };

		int temp = arr[0];
		int temp2 = arr[0];

		for (int a = 1; a < arr.length; a++) {

			if (arr[a] > temp) {
				temp = arr[a];
			}

			if (arr[a] < temp2) { // trye 2 > 0
				temp2 = arr[a];
			}
		}
		System.out.println("MIN " + temp2);
		System.out.println("MAX " + temp);
	}

}
