package examples1;

public class twoString {
    private int number;


    public twoString(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MyClass{" + "number=" + number + '}';
    }

    public static void main(String[] args) {
        twoString obj = new twoString(10);
        System.out.println(obj); // This will implicitly call obj.toString()
    }
}
