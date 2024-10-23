package interview;

import java.util.Arrays;

public class ArrayNlargest {

	public static void main(String[] args) {
		int num[] = { 1, 30, 32, 45, 58 };
		int max = num[0];
		int nth = num.length-2;

//		for (int i = 0; i < num.length; i++) {
//			if (max <= num[i]) {
//				max = num[i];
//			}
//
//		}System.out.println("Max" + max);



		Arrays.sort(num);
		System.out.println(num[nth]);


	}

}
