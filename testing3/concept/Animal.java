package concept;

public interface Animal {

	public abstract void eat();

	void sleep();

	public int MAX_AGE = 100;

	public static void info() {
		System.out.println("This is an info"+MAX_AGE);
	}

}