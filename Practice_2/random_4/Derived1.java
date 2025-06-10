
package random_4;

class Derived {
	private static void display() {
		System.out.println("Static or class method from Base");
	}

	public void print() {
		System.out.println("Non-static or instance method from Base");
	}
}

public class Derived1 extends Derived {
		private static void display() {
			System.out.println("Static or class method from Derived");
		}

		@Override
		public void print() {
			System.out.println("Non-static or instance method from Derived");
		}


		public static void main(String args[]) {
			Derived1 obj = new Derived1();
			Derived1.display();
			obj.print();
		}
	}
