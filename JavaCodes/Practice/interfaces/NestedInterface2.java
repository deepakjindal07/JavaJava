package interfaces;

class Test1 {
	interface dikhao {
		void show();
	}
}

class Kamdham implements Test1.dikhao {

	public void dikhado() {
		System.out.println("Show method of interface");
	}

	@Override
	public void show() {
		System.out.println("Show nothingx");
	}
}

public class NestedInterface2 {

	public static void main(String[] args) {

//		Kamdham kamdham = new Kamdham();
//		kamdham.nothing();

		Test1.dikhao obj;

		Kamdham x = new Kamdham();
		obj = x;
		x.show();

//		Test.nested obj;
//		Testing t = new Testing();
//		obj = t;
//		obj.show();
	}
}
