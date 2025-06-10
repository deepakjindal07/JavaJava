package basics_large;

public class OddEvenSort {
	public void oddEvenSort(int[] array) {
		boolean sorted = false;

		while (!sorted) {
			sorted = true;

			// Odd-even phase: comparing and swapping odd indexed elements
			for (int i = 1; i < array.length - 1; i += 2) {
				if (array[i] > array[i + 1]) {
					swapKeys(array, i, i + 1);
					sorted = false;
				}
			}

			// Odd-even phase: comparing and swapping even indexed elements
			for (int i = 0; i < array.length - 1; i += 2) {
				if (array[i] > array[i + 1]) {
					swapKeys(array, i, i + 1);
					sorted = false;
				}
			}
		}
	}

	public void swapKeys(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}