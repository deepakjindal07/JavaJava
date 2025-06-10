package random_1;

public class Intsum {

	public static void main(String[] args) {
		int num = 3456;

		String arr = Integer.toString(num);
		char[] c = arr.toCharArray();

		int temp =0; 
		for (char c1 : c)
		{
			System.out.println(c1);
			temp = temp+c1-'0';
		}
		
		System.out.println("Total "+temp);

	}

}
