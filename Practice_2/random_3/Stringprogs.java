package random_3;

public class Stringprogs {

	public static void main(String[] args) {
		String sample = "deepak kumar"; // output: ramuk kapeeD
		StringBuilder str = new StringBuilder(sample);

		// char x = str.charAt(str.length()-1);
		str.reverse();

		str.setCharAt(str.length() - 1, Character.toUpperCase(str.charAt(str.length() - 1)));

		// str.append(x);
		// str.replace(2, 5, sample);
		// X Character.toUpperCase(str.lastIndexOf(sample));

//		char[] b = sample.toCharArray();
//
//		b[b.length - 1] = Character.toUpperCase(b[b.length - 1]);
//		str.reverse().append(b);

		// str.replace(str.length()-1,str.length(),b);

		System.out.println(str);

	}

}
