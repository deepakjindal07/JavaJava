package random_1;

public class Test {

	public static void main(String[] args) {
		int[] in = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int min = 0;
		int max = 0;
		int first = in[0]; 
		for (int i : in)
		{
			if (i <= first)
			{
				min = i;
			}
			else if (i >= max)
			{
				max = i;
			}

		}
		System.out.println("Min " + min + " Max " + max);

	}

}
