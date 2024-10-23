package input.output;

public class CommandLineArguments2 {

	public static void main(String[] args) {

		if (args.length >= 0) {
			for (String x : args) {
				System.out.println(x);
			}
		}

		System.out.println("No");


	}
}
