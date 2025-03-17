package iInterview2;

// Example of Overriding in Java
class Animal {
	// Base class
	void move() {
		System.out.println("Animal is moving.");
	}

	void eat() {
		System.out.println("Animal is eating.");
	}
}

class Dog extends Animal {
	@Override
	void move() { // move method from Base class is overriden in this
					// method
		System.out.println("Dog is running.");
	}

	void bark() {
		System.out.println("Dog is barking.");
	}
}

public class Geeks {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.move(); // Output: Dog is running.
		d.eat(); // Output: Animal is eating.
		d.bark(); // Output: Dog is barking.
	}
}
