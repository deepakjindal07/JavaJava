package interfaces;

class Test {
	interface nested {
		void show();
	}
}

class Testing implements Test.nested {
	//Override
	@Override
	public void show() {
		System.out.println("Show method of interface");
	}

	public void nothing() {
		System.out.println("Show nothing");
	}
}

public class NestedInterface {

	public static void main(String[] args) {
		Test.nested obj;
		Testing t = new Testing();
		obj = t;
		obj.show();
	}
}
