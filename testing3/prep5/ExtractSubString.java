package prep5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractSubString {

	public static void main(String[] args) {
		String str = "abcd123@hotmail.com";
		String regex = "[a-z1-9@.]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = 
				pattern.matcher(str);

		while (matcher.find()) {
			System.out.println(matcher.group()); // Print the matched substring
		}
	}

}