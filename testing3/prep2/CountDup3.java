package prep2;

public class CountDup3 {


	public static void main(String[] args) {


		String str = "hello nasty World hello hello";

		// Hello == nasty, world, hello; yes
		// nasty == world, hello; No
		// World = Hello; No
		// Hello =

		String[] modify = str.split(" ");

		int g = modify.length;

		System.out.println("Words of ch in string" + g);
		// System.out.println(modify);

		for (int i = 0; i < modify.length; i++) {
			System.out.println("Outer"+i);

			for (int j = i+1; j < modify.length; j++) {
				System.out.println("Innerr"+j);

				if (modify[i] .equals(modify[j])) {
					System.out.println("Mil gya: " + modify[i]);
				}

			}

		}

	}

}
