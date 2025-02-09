package prep5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array_Stream {

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		List<Integer> a = new ArrayList<>();
		for (int i = 0; i < a1.length; i++)
		{
			a.add(a1[i]);
		}

		List<Integer> b = a.stream().filter((n) -> n > 2).collect(Collectors.toList());

		// List<Integer> list = arrList.stream().filter((n) -> n
		// >=5).collect(Collectors.toList());

		System.out.println(b.toString());

	}

}
