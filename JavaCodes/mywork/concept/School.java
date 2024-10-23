package concept;

public class School {

	private static School instance;

	private School() {
		//System.out.println("Hello");
	}


	public static School getInstance() {
		if (instance == null) {
			instance = new School();
		}
		return instance;

	}
}
