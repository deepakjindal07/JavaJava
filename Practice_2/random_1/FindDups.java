/**
 * 
 */
package random_1;

/**
 * 
 */
public class FindDups {

	public static void main(String[] args) {
		int[] in1 = { 5, 3, 4, 5, 3, 1 };

		for (int i = 0; i < in1.length - 1; i++)
		{
			for (int j = i ; j < in1.length - 1; j++)
			{
				if (in1[i] == in1[j+1])
				{
					System.out.println("dup " + in1[i]);
				}
			}
		}
	}

}
