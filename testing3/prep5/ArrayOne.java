package prep5;

import java.util.Arrays;

public class ArrayOne {

	public static void main(String[] args) {
		// Input: {3, 4, 5, 6, 7} → Output:{7, 3, 4, 5, 6}

		int[] arr = { 3, 4, 5, 6, 7 };
		int[] newArr = new int[arr.length];
		
		 newArr[0] = arr[arr.length - 1];

		for (int i = 0; i < arr.length - 1; i++)
		{
			newArr[i] = arr[i + 1];
		}

		System.out.println(Arrays.toString(newArr));

	}

}

//int[] arr = { 0, 1, 0, 3, 12 };
//int[] newarr = new int[arr.length];
//
//int point =0;
//for (int i = 0; i < arr.length ; i++)
//{
//	if (arr[i] != 0)
//	{
//		System.out.print("Yes");
//		newarr[point++] = arr[i];
//	}
//}
//
//System.out.println(Arrays.toString(newarr));
