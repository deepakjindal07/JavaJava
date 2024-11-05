package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array_Stream {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		List<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			arrList.add(arr[i]);
		}

		List<Integer> list = arrList.stream().filter((n) -> n >=5).collect(Collectors.toList());

		System.out.println(list.toString());

	}

}
