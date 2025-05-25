package pack2;

public class Armstrong {

	public static void main(String[] args) {
		int a = 123;
		int value = 0;

		String numStr = String.valueOf(a); // Convert to String
		int[] arr = new int[numStr.length()]; // Create an array of same length

		for (int i = 0; i < numStr.length(); i++)
		{
			arr[i] = numStr.charAt(i) - '0'; // Convert char to int
		}

		for (int p : arr)
		{
			System.out.println(p);
			for (int i = 0; i <= numStr.length(); i++)
			{
				value = value + p * p;
				//System.out.println("dasdf"+value);

			}

		}

		System.out.println("Total : " + value);
	}

}
