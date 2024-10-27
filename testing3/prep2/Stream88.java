package prep2;

import java.util.Arrays;


public class Stream88
{
	public static void main(String[] args) {
		String[] str ={"This", "is a sample", "string"};

		Arrays.stream(str).forEach(System.out::println);

		Arrays.asList(str).forEach(e -> System.out.println(e));
	}
}
