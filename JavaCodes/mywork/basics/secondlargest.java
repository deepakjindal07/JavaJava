package basics;

public class secondlargest {
	public static void main(String[] args) {
		int a[] = { 0, -1, 3, 5, 2 };
		int max = Integer.MIN_VALUE;
		int secondMax = max;
		int min = a[0];
		for (int element : a) {
			if (max < element) {
				secondMax = max;
				max = element;
			} else if (secondMax < element && element != secondMax) {
				secondMax = element;
			}

			else if (min > element) {
				min = element;
			}

		}
		System.out.println("max :" + max);
		System.out.println("Second Max :" + secondMax);
		System.out.println("min :" + min);

	}
}
