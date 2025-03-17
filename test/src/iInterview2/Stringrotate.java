package iInterview2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Stringrotate {

	public static void main(String[] args) {
		int[] ind = { 1, 3, 4, 2, 5, 3, 6, 2 };

		Arrays.sort(ind);

		List<Integer> result;

		HashSet<Integer> in = new HashSet<>();

//		for (int i : ind)
//		{
//			in.add(i);
//		}

		result = in.stream().filter((i) -> i > 0).collect(Collectors.toList());

		System.out.println(result.toString());
	}

}
