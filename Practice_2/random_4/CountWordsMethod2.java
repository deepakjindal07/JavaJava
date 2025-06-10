package random_4;

public class CountWordsMethod2 {

	public static void main(String[] args) {
		String str = "I love pizza, burger and pasta";

		int x= str.replaceAll(" ", "").length();

		System.out.println(x);

	}

}
