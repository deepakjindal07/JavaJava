package random_7;

public class NameRevers {

	public static void main(String[] args) {
		String str = "DeepakKumar"; // ramuKkapeeD
		
		StringBuilder SB = new StringBuilder(str).reverse();
		
		//char lastChar = SB.charAt(SB.length()-1);
		SB.setCharAt(SB.length()-1, Character.toUpperCase(SB.charAt(SB.length()-1)));

		
		System.out.println(0x1F600);
				

	}

}
