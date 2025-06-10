package random_4;

public class Replace {

	public static void main(String[] args) {
		String one = "Hello"; String two ="World";
		String three = one.replace("e", "XXX");

		//modifyLast(three);

		String four = one.substring(0, one.length()-1)+one.substring(one.length()-1).toUpperCase();
  //one = one.substring(0, one.length()-1)+one.substring(one.length()-1).toUpperCase();



		System.out.println(four);

	}

	private static void modifyLast(String three) {
		//String c = three.toUpperCase(three);




	}

}
