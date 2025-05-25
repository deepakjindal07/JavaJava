package pack2;

public class ArryMerg {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 6, 7, 8, 9 };
		int[] c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++)
		{
			c[i] = a[i];
		}

		for (int i = 0; i < b.length; i++)
		{
			c[i + b.length] = b[i];
		}

		for (int i : c)
		{
			System.out.println(i);
		}

	}

}
