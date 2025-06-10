package basics_large;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchCollections {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();

		al.add(10);
		al.add(22);
		al.add(45);
		al.add(57);
		al.add(98);

		int key = 57;
		int res = Collections.binarySearch(al, key);
		if(res >= 0){
			System.out.println(key + " found at index: "+res);
		} else {
			System.out.println(key + " not found");
		}
	}
}
