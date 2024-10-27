package prep2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDupCollections {

	public static void main(String[] args) {
		// How to Remove All Duplicates from an ArrayList

		List<Integer> al = new ArrayList<>();

		al.add(4);
		al.add(4);
		al.add(5);

		Arrays.asList(al);

		List<Integer> removedVals = al.stream().distinct().collect(Collectors.toList());

		System.out.println(removedVals);

	}

}
