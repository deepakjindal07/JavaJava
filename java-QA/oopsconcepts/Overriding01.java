package oopsconcepts;

class Parent {
	void show() {
		System.out.print("Parent Class");
	}
	void ManCry() {
		System.out.println("gfKickedMe");
	}
}

class Child extends Parent {
	//@Override
	void show() {
		//this.show();
		System.out.println("\nChild Class");
	}
	
	void babyCry() {
		System.out.println("IamaCryBaby");
	}
}

public class Overriding01 {

	public static void main(String[] args) {
		//Child child = new Child();
		//Parent parentTYpe = (Parent)child; // parentType.show();

		((Child) parentTYpe).babyCry();
	}

}
