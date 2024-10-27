package prep2;

public class RevPyramid {

	public static void main(String[] args) {

		pattern3(6);

	}

	// Reverse triange
	@SuppressWarnings("unused")
	private static void pattern1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i + 1; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

	}

	// Normal Rtriangle
	@SuppressWarnings("unused")
	private static void pattern2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	// Proper triangle
	private static void pattern3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int x = 0; x < n-i/2; x++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
