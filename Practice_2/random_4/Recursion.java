package random_4;

public class Recursion {

	public static void count(int x) {
		if (x > 1) {
			count(x - 1);
		}
		System.out.println(x);

	}

	public static void main(String[] args) {

		//int a = 10;
		count(10);

	}
}
