package prep2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BulkMissingArrayNumber {

	public static void main(String[] args) {
		int[] numarr = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 10 };

		// Method1(numarr);
		// Method2(numarr);
		// FindDupHasSet(numarr);
		FindDupHasMap(numarr);
	}

	private static void FindDupHasMap(int[] numarr) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i : numarr) {

			if (hm.containsKey(i)) {
				hm.put(i, hm.get(i) + 1);
			} else {
				hm.put(i, 1);
			}
		}

		// System.out.println(hm);

		for (Map.Entry<Integer, Integer> hmP : hm.entrySet()) {
			System.out.println(hmP.getKey());
		}

	}

	private static void FindDupHasSet(int[] numarr) {

		HashSet<Integer> hs = new HashSet();

		for (int x : numarr) {
			if (!hs.add(x)) {
				System.out.println("Dup" + x);
			}
		}

	}

	private static void Method2(int[] numarr) {
		Arrays.sort(numarr);

		Set<Integer> actualSet = new HashSet<>();
		for (Integer integer : numarr) {
			actualSet.add(integer);
		}

		Set<Integer> expectedSet = new HashSet<>();
		for (int i = numarr[0]; i <= numarr[numarr.length - 1]; i++) {
			expectedSet.add(i);
		}

		expectedSet.removeAll(actualSet);

		System.out.println(expectedSet);
	}

	private static void Method1(int[] numarr) {
		int temp = 0;

		for (int i = 0; i <= numarr.length - 1; i++) {

			temp += numarr[i];

//			if (numarr[i] + numarr[i] + 1 == numarr[i + 2]) {
//				System.out.println(numarr[i]);
//			} else {
//				System.out.println("MissingFound" + numarr[i]);
//			}

		}
		System.out.println(55 - temp);

	}

}
