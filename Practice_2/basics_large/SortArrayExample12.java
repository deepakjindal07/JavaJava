package basics_large;
import java.util.Arrays;

public class SortArrayExample12 {
	public static void main(String[] args) {
//defining an array of integer type
		int[] array = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };
//invoking sort() method of the Arrays class
		Arrays.sort(array);
		System.out.println("Elements of array sorted in ascending order: ");
//prints array using the for loop
		for (int element : array) {
			System.out.println(element);
		}
	}
}
