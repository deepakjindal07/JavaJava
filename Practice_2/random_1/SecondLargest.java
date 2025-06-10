package random_1;

public class SecondLargest {

	public static void main(String[] args) {
		int[] inArr = { 1, 2, 3, 4, 5, 6, 7 };
		int max = 0;
		int smax = 0;

		for (int i = 0; i < inArr.length; i++)
		{
			if (inArr[i] > max)
			{
				smax = max;
				max = inArr[i];
			}
		}
		System.out.println("Max " + smax);
	}

}
