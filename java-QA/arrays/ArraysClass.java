package arrays;
import java.util.Arrays;
import java.util.List;

public class ArraysClass {

	public static void main(String[] args) {
		Integer arr[] = {4, 6, 5, 8, 3, 9, 7, 3, 2, 8};
		
		System.out.println("Arrays: " + Arrays.toString(arr));
		
/*		Arrays.sort(arr, 0, 5);
		System.out.println("Half Sorted Arrays: " + Arrays.toString(arr));
		
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 1);
		System.out.println("Position of 9 in sorted arrays is: " + index);
		
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		System.out.println("Copies arrays: " + Arrays.toString(copyArr));
		
		Arrays.fill(arr, 0, 3, 5);
		System.out.println("Arrays filled with 5 from 0 to 3: "+ Arrays.toString(arr));*/
		
		//Integer[] newArr = ArrayUtils.toObject(arr);
		
		List<Integer> al = Arrays.asList(arr);
		System.out.println("As a List() :" + al);
	}
}
