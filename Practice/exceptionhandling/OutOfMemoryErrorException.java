package exceptionhandling;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorException {

	static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		Integer[] array = new Integer[10000 * 10000];

		System.out.println(array);
	}

}
