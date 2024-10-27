package interview;

public class simplePrint {

	public static void main(String[] args) {
		String[] str = { "Tik", "Tok" };

		for (int count = 3; count >= 0; count--) {
			for (int i = 0; i <= str.length - 1; i++) {
				System.out.println(str[i]);

			}
		}
	}
}
