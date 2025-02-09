package prep2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BulkStreamSample {

	public static void main(String[] args) {

		// Stream1();
		// Stream2();
		// Stream3();
		// Stream4(); // distinct or remove duplicate from arraylist.
		// Stream5(); // reverse words in sentence.
		Stream6(); // sort array list.

	}

	private static void Stream6() {
		List<String> listofStrings = Arrays.asList("India", "America", "Kanada", "Zaa1");

		List<String> answer = listofStrings.stream().sorted().collect(Collectors.toList());

		System.out.println(answer);

	}

	private static void Stream5() {
		String input = "Hello to the world of Java";
		String[] strArr = input.split(" ");

		List<String> answer = Arrays.stream(strArr).map((word) -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.toList());

		System.out.println(answer);

	}

	private static void Stream4() {
		List<String> listofStrings = Arrays.asList("one", "two", "two", "four");

		List<String> result = listofStrings.stream().distinct().collect(Collectors.toList());

		System.out.println(result);

	}

	private static void Stream3() {
		List<String> listofStrings = Arrays.asList("one", "two", "three", "four");

		String ans = listofStrings.stream().skip(listofStrings.size() - 1).findFirst().get();

		System.out.println(ans);

	}

	private static void Stream2() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		numbers.stream().filter((n) -> n % 2 == 0).forEach((n) -> {
			System.out.println((n));
		});

	}

	private static void Stream1() {
		int number = 12345;

		IntStream stream = String.valueOf(number).chars();

		int num = stream.mapToObj(c -> Character.getNumericValue((char) c)).filter(i -> i != -1)
				.mapToInt(Integer::intValue).sum();

		System.out.println(num);

	}

}
