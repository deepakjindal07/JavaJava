package random_4;

class Animal {
//	Animal() {
//		System.out.println("Animal is created");
//	}


	void sound() {
		System.out.println("Generic sound");
	}

}

class Dog extends Animal {
//	Dog() {
//		System.out.println("Dog is created");
//	}

	@Override
	void sound() {
		System.out.println("Dog sound");
	}
}

public class Main {
	public static void main(String[] args) {
		Animal d = new Animal();
		d.sound();
	}
}
