package prep2;

public class Capswithoutfunc {

	public static void main(String[] args) {
		String str = "This is the Text";
		char[] ch = str.toCharArray();

		for(int i=0;i<ch.length;i++) {

			ch[i] = Character.toUpperCase(ch[i]);

			System.out.print(ch[i]);
		}

	}

}
