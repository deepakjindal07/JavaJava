package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class HashSetMerge {

	public static <T>Set<T> mergeSet(Set<T> a, Set<T> b) {
		//Creating an empty set
		Set<T> mergedSet = new HashSet<>();
		mergedSet.addAll(a);
		mergedSet.addAll(b);

		return mergedSet;
	}
	public static void main(String[] args) {
		//First Set
		Set<Integer> a = new HashSet<>();
		a.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7, 9}));

		//Second Set
		Set<Integer> b = new HashSet<>();
		b.addAll(Arrays.asList(new Integer[] {0, 2, 4, 6, 8}));

		System.out.println("Set a: "+ a);
		System.out.println("Set b: "+ b);
		System.out.println("Merged Set: "+ mergeSet(a, b));

	}

}
