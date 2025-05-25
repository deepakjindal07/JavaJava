package empty;

public class hh {

	public static void main(String[] args) {
		String str = "deepak kumar"; // output : ramuk kapeeD

		StringBuilder sb = new StringBuilder(str).reverse();

		String newStr = sb.substring(0, sb.length() - 1) + Character.toUpperCase(sb.charAt(sb.length() - 1));

		System.out.println(newStr);

	}

}
