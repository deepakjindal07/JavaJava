package interview;

public class Last4String {

	public static void main(String[] args) {
		String str = "www.google.com";

		// GetLast4Word(str);
		// Reversework(str);
		LastDigitCap(str);
	}

	private static void LastDigitCap(String str) {
		char[] x = str.toCharArray();
		int last = str.length();

		x[last-1] = Character.toUpperCase(x[last-1]);

		System.out.println(x);
	}

	private static void Reversework(String str) {
		StringBuffer x = new StringBuffer(str);
		String y = x.reverse().toString();
		System.out.println(y);
	}

	private static void GetLast4Word(String str) {
		// Extract last 4 character from string.
		String First4 = str.substring(0, 4);
		int last4int = str.length() - 4;
		String Last4 = str.substring(str.length() - 4);
		System.out.println(Last4);
	}
}
