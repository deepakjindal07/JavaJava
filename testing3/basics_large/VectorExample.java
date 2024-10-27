package basics_large;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VectorExample {

    public static void main(String[] args) {
        // Use ArrayList instead of Vector for modern Java practices
        List<String> vec = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements to add to the Vector:");

        // Adding elements to the ArrayList
        vec.add("Hello");
        vec.add("World");
        vec.add(sc.nextLine());  // Taking input from user

        System.out.println("The size of the Vector is: " + vec.size());

        // Printing elements of the ArrayList using a for-each loop
        System.out.println("The elements in the Vector are:");
        for (String element : vec) {
            System.out.println(element);
        }

        System.out.println("The Vector contains 'World': " + vec.contains("World"));

        // Removing an element from the ArrayList
        if (vec.remove("World")) {
            System.out.println("'World' removed from the Vector.");
        } else {
            System.out.println("'World' not found in the Vector.");
        }

        // Printing the final state of the Vector
        System.out.println("The Vector after removal:");
        for (String element : vec) {
            System.out.println(element);
        }
    }
}
