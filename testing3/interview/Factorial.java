package interview;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(factory(1));
		System.out.println(factory(5));

//		Map<Integer,String> something = new HashMap<>();
//		something.add

	}

	public static int factory(int x) {

		int factorial = 1;

		for (int a = 0; a <= x; a++) {

			factorial = factorial * x;

		}
		return factorial;

	}

}
