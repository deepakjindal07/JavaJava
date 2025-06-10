package empty;

import java.util.Arrays;
import java.util.Scanner;

public class GgTemp {

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int temp = 0;

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length-1; j++)
			{
				if (arr[j] > arr[j+1])
				{
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
