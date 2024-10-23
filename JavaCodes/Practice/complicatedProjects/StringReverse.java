package complicatedProjects;

public class StringReverse {

	static void reverse(String str) {
		char[] inputArray = str.toCharArray();
		char[] result = new char[inputArray.length];

		// Mark spaces in result
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == ' ') {
				result[i] = ' ';
			}
		}

		// Traverse input string from beginning
		// and put characters in result from end
		int j = result.length - 1;
		for (char element : inputArray) {

			// Ignore spaces in input string
			if (element != ' ') {

				// ignore spaces in result.
				if (result[j] == ' ') {
					j--;
				}
				result[j] = element;
				j--;
			}
		}
		System.out.println(String.valueOf(result));
	}

	public static void main(String[] args) {
		reverse("Pradeep Kumar");
	}
}
