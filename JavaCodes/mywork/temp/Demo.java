package temp;

public class Demo {

	static Demo obj = new Demo();

	static {
		System.out.println("InsideStaticBlock " + Demo.obj);
		Demo.init();

	}

	public static void main(String[] args) {
		System.out.println("insideMain " + Demo.obj);

	}

	static void init() {

		System.out.println("InsideInit ");
		Demo.obj = new Demo(); // Gives same address.
		// new Demo(); // Gives different address
	}

}
