package random_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamingHot {

	public static void main(String[] args) {

		int[] i = { 1, 2, 3, 4, 5 };

		List<Integer> bin = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		Stream<Integer> MyStream0 = bin.stream();

		IntStream myStream1 = Arrays.stream(i);

		Stream<Integer> myStream2 = Stream.of(1, 2, 3, 4);

		List<Integer> bin2 = MyStream0.filter((x) -> x > 3).collect(Collectors.toList());
		//System.out.println(bin2);
		
		List<Integer> example = Stream.iterate(0, x -> x+1)
				.limit(10)
				.skip(1)
				.filter(x -> x%2 ==0)
				.map(x->x/10)
				.collect(Collectors.toList());
				
				System.out.println(example);
	}

}
