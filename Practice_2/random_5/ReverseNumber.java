package random_5;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = 1234567;

//		String numStr = String.valueOf(num);
//		StringBuilder sb = new StringBuilder(numStr).reverse();
//		System.out.println(sb);

		for (int i = 0; i <= 10; i++) {
			num = num % 10;
			int temp =0;
			temp+=num;
			System.out.println(temp);
		}

	}

}
