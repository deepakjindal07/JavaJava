package newPackage;

public class Singleton {

	// Step 1: Create a private static instance of the class
	private static Singleton instance;

	// Step 2: Private constructor to prevent instantiation from outside
	private Singleton() {
		System.out.println("Singleton instance created.");
	}

	// Step 3: Public method to provide access to the instance
	public static Singleton getInstance() {
		if (instance == null)
		{
			instance = new Singleton(); // Lazy initialization
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello from Singleton!");
	}

	public static void main(String[] args) {

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		//obj1.showMessage();

		System.out.println(obj1 == obj2); // true – both point to same instance

	}
}