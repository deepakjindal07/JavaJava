package com.misc;
import java.util.Arrays;
/**
 * Note:-
 * java.util.Arrays uses quicksort for primitive types such as int and
 * mergesort for objects that implement Comparable or use a Comparator.
 */
public class ArraySort {

	public static void main(String[] args) {
		String[] countries = {"India","United States","Malaysia","Australia","Lundon"};
		Arrays.sort(countries);
		for (String element : countries) {
			System.out.println(element);
		}
	}
}
