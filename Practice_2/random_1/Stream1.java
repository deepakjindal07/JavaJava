package random_1;

import java.util.Arrays;
import java.util.List;

public class Stream1 {

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 2, 10, 4, 5, 6);

		List<Integer> result = ls.stream().map(n -> n + 1).sorted((a, b) -> (b-a)).limit(4).toList();
		

		System.out.println(result);

	}

}
