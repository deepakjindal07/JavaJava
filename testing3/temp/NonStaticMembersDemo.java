package temp;

public class NonStaticMembersDemo {

	int val;

	NonStaticMembersDemo() {
		System.out.println("InsideStaticConstructor");
	}

	{
		System.out.println("InsideNonStaticBlock");
	}

	public static void main(String[] args) {
		new NonStaticMembersDemo();
		new NonStaticMembersDemo();

		NonStaticMembersDemo obj = new NonStaticMembersDemo();
		obj.doSomething();

	}

	void doSomething() {
		System.out.println("oooInsideDoSomething ");
	}

}
