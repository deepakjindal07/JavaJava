package complicatedProjects;

public class ReverseWordInString {

	public void reverse(String str) {
		String[] words = str.split(" ");
		String result = "";
		for (String word : words) {
			String reversedWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reversedWord = reversedWord + word.charAt(j);
			}
			result = result + reversedWord + " ";
		}
		System.out.println(str);
		System.out.println(result);
	}

	public static void main(String[] args) {
		ReverseWordInString obj = new ReverseWordInString();
		obj.reverse("Pradeep Kumar");
	}
}
