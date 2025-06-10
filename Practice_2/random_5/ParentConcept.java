package random_5;

class Parent {
	int i = 100;

	void jobstatus() {
		System.out.println("BusinessMen");
	}
}

class Child extends Parent {
	int i = 10;

	//@Override
	void jobstatus() {
		System.out.println("Student");
	}
}

public class ParentConcept {

	public static void main(String[] args) {

		Parent p = new Parent();
		System.out.println(((Child)p).i);
		 p.jobstatus();
		 
		 

	}

}
