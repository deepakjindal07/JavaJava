package prep2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDupAL {

	public static void main(String[] args) {
		// How to Remove All Duplicates from an ArrayList

		List<Integer> al = Arrays.asList(1, 1, 5, 3, 4, 5, 5, 5, 5);

		// Arrays.asList(al);

		Map<Integer, Integer> bl = new HashMap<>();

		int count = 0;
		for (Integer element : al) {

			bl.put(count + 1, element);
			count++;
		}

		System.out.println(bl);

	}

}
