package basics_large;

public class KadaneAlgo {
	public static void main(String[] args) {
		System.out.println(kadaneAlgo(new int[] { 1, 2, 3, 4, -10, 11, -1 }));
	}

	public static int kadaneAlgo(int[] arr) {
		int max = arr[0], sum = 0;
		int len = 0;
		for (int element : arr) {
			sum += element;
			len++;
			if (sum > max) {
				max = sum;
			}
			if (sum <= 0) {
				sum = 0;
				len = 0;
			}
		}
		return len;
	}
}
