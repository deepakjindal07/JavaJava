package random_8;
import java.util.Arrays;

public class SortSubarray {

	public static void main(String[] args) {

		int arr[] = { 13, 7, 6, 45, 21, 9, 2, 100 };
		Arrays.sort(arr, 0, 5);
		System.out.printf("Sorted Array: %s ", Arrays.toString(arr));
	}
}
