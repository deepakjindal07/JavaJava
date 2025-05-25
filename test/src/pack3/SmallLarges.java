package pack3;

import java.util.Arrays;

public class SmallLarges {

	public static void main(String[] args) {

		int[] arr = { 1, 7, 6, 5, 4, 3, 2 };
		//int[] arr2 = new int[5];

		for (int i = 0; i < arr.length-1; i++)
		{
			for (int j = 0; j < arr.length-1-i; j++)
			{
				
				System.out.print(arr[j]);
				
//				if (arr[j] > arr[j + 1])
//				{
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
				//System.out.println(arr[j]);
			}
			System.out.println();
			

		}
		System.out.println(Arrays.toString(arr));

	}
}
