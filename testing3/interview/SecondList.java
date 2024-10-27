package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondList {

	public static void main(String[] args) {
		Integer[] arr = { 5, 6, 88, 2, 36, 95 };
		List<Integer> list = Arrays.asList(arr);

		Collections.sort(list, Collections.reverseOrder());

		if (list.size() < 2) {
			throw new IllegalArgumentException("List should have at least 2 elements.");
		}

		int secondLargest = list.get(1);
		System.out.println("Second largest element: " + secondLargest); // 88

		// another method.
		//Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();


	}

}
