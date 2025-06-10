package random_5;

public class Fibonnaci {

	public static void main(String[] args) {

		int n = 10;

		int first = 0;
		int second = 1;

		System.out.println("Print till " + n);

		for (int i = 1; i < n; ++i)
		{

            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;

		}
	}
}