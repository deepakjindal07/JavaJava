package empty;

import java.util.LinkedHashSet;
import java.util.Set;

public class MissingFinder {

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 5, 6, 7 };

		Set<Integer> se = new LinkedHashSet<>();

		for (int n : num)
		{
			se.add(n);
		}

		for (int i = 1; i <= num.length; i++)
		{
			if (!se.contains(i))
				System.out.println("Missing Number: " + i);
			
		}

	}

}
