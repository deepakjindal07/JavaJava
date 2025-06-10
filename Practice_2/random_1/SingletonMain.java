package random_1;

class Singleton {

	// Step 1: Create a private static instance of the class
	private static Singleton instances;

	// Step 2: Private constructor to prevent instantiation from outside
	private Singleton() {
		System.out.println("Singleton instance created.");
	}

	// Step 3: Public method to provide access to the instance
	public static Singleton getInstance() {
		if (instances == null)
		{
			instances = new Singleton(); // Lazy initialization
		}
		return instances;
	}

	public void showMessage() {
		System.out.println("Hello from Singleton!");
	}

}

public class SingletonMain {

	public static void main(String[] args) {

		Singleton obj1 = Singleton.getInstance(); // create a new object
		Singleton obj2 = Singleton.getInstance();

		//Singleton newObj = new Singleton();

		obj1.showMessage();
		obj2.showMessage();
		//newObj.showMessage();

		System.out.println(obj1 == obj2); // true – both point to same instance
		//System.out.println(newObj == obj2);
	}
}