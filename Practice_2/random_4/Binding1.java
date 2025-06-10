package random_4;

class Parent {
    void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void print() {
        System.out.println("Child");
    }
}

public class Binding1 {
    public static void main(String[] args) {
        Parent p = new Child(); // Parent reference pointing to a Child object
        p.print(); // Dynamic binding: calls the print() method of the Child class
    }
}