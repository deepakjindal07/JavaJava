package collections;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DictionaryExample {

	public static void main(String[] args) {
		Dictionary<Integer, String> dictionary = new Hashtable<>();

		dictionary.put(100, "Hello");
		dictionary.put(101, "World");

		// elements() method
		for (Enumeration<String> i = dictionary.elements(); i.hasMoreElements();)
		{
			System.out.println("Value in Dictionary: " + i.nextElement());
		}

		System.out.println("Value at key = 100: " + dictionary.get(100));
		System.out.println("There is no key-value pair: " + dictionary.isEmpty());

		// keys() method
		for (Enumeration<String> k = dictionary.elements(); k.hasMoreElements();)
		{
			System.out.println("Keys in Dictionary: " + k.nextElement());
		}

		System.out.println("Remove: " + dictionary.remove(100));
		System.out.println("The value of remove key 100: " + dictionary.get(100));
		System.out.println("Size of Dictionary: " + dictionary.size());
	}
}
