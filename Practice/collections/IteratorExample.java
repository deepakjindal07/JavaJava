package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {
		// Create an ArrayList with type safety
		ArrayList<Integer> al = new ArrayList<>();

		// Adding numbers 0 to 9
		for (int i = 0; i < 10; i++)
		{
			al.add(i);
		}

		// Print the original list
		System.out.println("Original List: " + al);

		// Using an Iterator to traverse and remove odd numbers
		Iterator<Integer> itr = al.iterator();

		while (itr.hasNext())
		{
			int i = itr.next(); // Get the next element

			System.out.print(i + " "); // Print the element

			// Remove if the number is odd
			if (i % 2 != 0)
			{
				itr.remove();
			}
		}

		System.out.println(); // New line
		System.out.println("Modified List (Even Numbers Only): " + al);
	}

}
