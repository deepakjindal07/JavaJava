package prep5;

import java.util.Arrays;

public class Desc {
	public static void main(String[] args) {
	    int[] arr = {2, 4, 3, 5, 6, 7, 1};
	    
	    Arrays.sort(arr);

//	    for (int i = 0; i < arr.length - 1; i++) {
//	        for (int j = i + 1; j < arr.length; j++) {
//	            if (arr[i] <= arr[j]) {  // 2 > 1
//	                int temp = arr[i];  // temp = 2
//	                arr[i] = arr[j]; // 2Now1
//	                arr[j] = temp; // 1Now2
//	            }
//	        }
//	    }

	    for (int x : arr) {
	        System.out.println(x);
	    }
	}

}
