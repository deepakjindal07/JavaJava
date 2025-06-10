package random_3;

import java.util.HashSet;

public class Arrayxyz {

	public static void main(String[] args) {
		int[] inrr = { 1, 2, 3, 5, 6, 7 };

		for (int i = 0; i < inrr.length; i++)
		{
			for (int j = i; j < inrr.length - 1; j++)
			{
				if (inrr[i] == inrr[j + 1])
				{
					System.out.println("Missing number: " + inrr[i]);
				}
			}
		}

		FindMissing(inrr);

	}

	private static void FindMissing(int[] inrr) {

		HashSet<Integer> hs = new HashSet<>();

		for (int i : inrr)
		{
			hs.add(i);
		}

		// Print
		for (int i = 0; i < inrr.length; i++)
		{
			if (!hs.contains(i))
			{
				System.out.println("Missing nUmber is: " + i);
			}
		}

	}

}
