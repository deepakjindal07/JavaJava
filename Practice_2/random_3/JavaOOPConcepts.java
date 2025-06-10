package random_3;

class SuperClass {
	String superClassField = "Super_Class_Field";

	void superClassMethod() {
		System.out.println("Super_Class_Method");
	}
}

class SubClass extends SuperClass {
	String subClassField = "Sub_Class_Field";

	void subClassMethod() {
		System.out.println("Sub_Class_Method");
	}
}

public class JavaOOPConcepts {
	public static void main(String[] args) {
		SuperClass SubClass = new SuperClass();

		SubClass.superClassMethod();

	}
}