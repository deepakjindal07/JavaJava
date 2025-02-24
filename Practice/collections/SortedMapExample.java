package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

	public static void main(String[] args) {
		// Creating a SortedMap (TreeMap maintains sorted order)
		SortedMap<Integer, String> sm = new TreeMap<>();

		// Adding elements to the map
		sm.put(2, "A");
		sm.put(3, "B");
		sm.put(5, "C");
		sm.put(4, "D");
		sm.put(1, "E");

		// Iterating using for-each loop (modern approach)
		for (Map.Entry<Integer, String> entry : sm.entrySet())
		{
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
	}
}
