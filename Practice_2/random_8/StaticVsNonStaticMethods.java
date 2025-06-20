package random_8;

public class StaticVsNonStaticMethods {

	public static void main(String[] args) {
		StaticVsNonStaticMethods obj = null;
		StaticVsNonStaticMethods.staticMethod();
		obj.nonStaticMethod();
	}

	private static void staticMethod() {
		System.out.println("Static method, can be called by null reference");
	}

	private void nonStaticMethod() {
		System.out.println("Non-static method- ");
		System.out.println("Cannot be called by null reference");
	}
}
