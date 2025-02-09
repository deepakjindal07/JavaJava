package prep5;

public class DifferentTypes {

	int value;

	DifferentTypes() {
		System.out.println("Inside constructor");
	}

	{
		System.out.println("Inside the non-static block");
	}

	public static void main(String[] args) {
		DifferentTypes d = new DifferentTypes();
		System.out.println(d.value);

	}
}
