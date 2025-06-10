package empty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class hh {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 4, 4, 5, 5, 5, 6, 7, 8 };
		
		Set<Integer> set = new LinkedHashSet<>();
		//LinkedHashSet<Integer> hs = new LinkedHashSet<>(Arrays.asList(arr));		
		Arrays.asList(set);
		
		Integer[] newArr = set.toArray(new Integer[0]);
        System.out.println("Array after removing duplicates: " + Arrays.toString(newArr));
        
	}
}
