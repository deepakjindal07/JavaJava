package basics;

public class VariablesScope01 {

	static int x = 10;
	private int y = 20;

	public void method(int x){
		VariablesScope01 v = new VariablesScope01();
		VariablesScope01.x = 30;
		y = 40;

		System.out.println("Local value of x: "+ VariablesScope01.x);
		System.out.println("Global value of y: "+ v.y);
		System.out.println("Local value of y: "+ y);

	}

	public static void main(String[] args) {
		VariablesScope01 v = new VariablesScope01();
		v.method(5);
	}
}
