package basics_large;
import java.util.Arrays;

public class SortArrayExample1 {

    public static void main(String[] args) {
        int[] array = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };

        // Sort the array in ascending order
        Arrays.sort(array);

        System.out.println("Elements of the array sorted in ascending order: ");

        // Print sorted array using a for-each loop
        for (int num : array) {
            System.out.println(num);
        }
    }
}
