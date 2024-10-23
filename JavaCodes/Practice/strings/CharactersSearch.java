package strings;

public class CharactersSearch {

	public static void main(String[] args) {
		String str = "Hello World";

		int fi = str.indexOf('H');
		System.out.println("First occurence of char 'H' is found at: " + fi );

		int li = str.lastIndexOf('l');
		System.out.println("Last occurence of char 'l' is found at: " + li );

		int fo = str.indexOf('W', 4);
		System.out.println("First occurence of char 'W' is found at : " + fo);

		int char_at = str.charAt(0); // ASCII Value of H
		System.out.println("Character at location 20: " + char_at);

		CharSequence seq = "World";
		boolean val = str.contains(seq);
		System.out.println("Found World ?: "+ val);

		// Substring search
		System.out.println("'Hello' found in String: " + str.startsWith("Hello"));
	}
}
