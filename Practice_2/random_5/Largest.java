package random_5;

public class Largest {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int temp = 1;
		for (int i = 0; i < arr.length; i++)
		{
			if (temp <= arr[i])
			temp = arr[i];
		}
		System.out.println(temp);
	}

}
