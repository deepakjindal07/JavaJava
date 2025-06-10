package random_3;

import java.util.HashSet;

public class Sumarray {

	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5,7}; // Missing 3, 5, 6
	        int n = 6; // Full range

	        HashSet<Integer> set = new HashSet<>();
	        for (int num : arr) {
	            set.add(num);
	        }

	        System.out.print("Missing Numbers: ");
	        for (int i = 1; i <= n; i++) {
	            if (!set.contains(i)) {
	                System.out.print(i + " ");
	            }
	        }
	    }

}
