package random_4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 50, 100, 100, 100, 200);

		List<Integer> arr2 = arr1.stream().filter(x -> x > 5).distinct().sorted((a, b) -> (b - a)).map(x -> x + 1)
				.collect(Collectors.toList());

		System.out.println(arr2);

//		Optional x = Stream.max((a,b) -> a-b);

	}

}
