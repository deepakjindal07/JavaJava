package collections;

import java.util.AbstractCollection;
import java.util.TreeSet;

public class AbstractCollectionExample {

	public static void main(String[] args) {
		AbstractCollection<String> abs1 = new TreeSet<>();

		abs1.add("One");
		abs1.add("Two");
		abs1.add("Three");

		System.out.println("AbstractCollection 1: " + abs1);

		AbstractCollection<String> abs2 = new TreeSet<>();

		abs2.addAll(abs1);

		System.out.println("Abstract Collection 2: " + abs2);

		abs1.clear();

		System.out.println("AbstractCollection 1: " + abs1);

		System.out.println("Is the collection empty ? " + abs1.isEmpty());

	}

}
