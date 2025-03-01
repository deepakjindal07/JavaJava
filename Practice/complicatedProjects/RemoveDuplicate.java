package complicatedProjects;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicate {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("two");
		list.add("one");
		list.add("three");
		list.add("one");
		list.add("four");

		ArrayList<String> list2 = new ArrayList<>(new HashSet<>(list)); // no elements order
		// ArrayList<String> list2 = new ArrayList<String>(new LinkedHashSet<String>(list)); //To preserve the order of the elements
		Iterator<String> itr = list2.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
