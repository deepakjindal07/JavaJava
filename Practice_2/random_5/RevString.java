package random_5;

public class RevString {

	public static void main(String[] args) {
		String str = "HelloJava";
		char[] ch = str.toCharArray();

		String temp = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			temp = temp + ch[i];

		}
		System.out.println(temp);
	}

}
