package test;

public class test {
	public static void main(String[] args) {

		String str = "deepakkumar";
		StringBuilder stb = new StringBuilder(str).reverse();

		String x = stb.toString();

		int lastIndex = stb.length() - 1;
		stb.setCharAt(lastIndex, Character.toUpperCase(stb.charAt(stb.length() - 1)));

		System.out.println(stb.toString());
	}
}
