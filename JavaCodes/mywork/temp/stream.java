package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("abc");
        list.add("terminator");
        list.add("Simsons");

        System.out.println(list.toString());

        // Filter and collect to a new list
        List<String> filteredList = list.stream()
                .filter(line -> !line.equals("abc")) // Use line instead of link
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filteredList); // Print filtered list

    }

}
