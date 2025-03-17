package iInterview2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Itera {

	public static void main(String[] args) {
		List<String> listName = new ArrayList<>(Arrays.asList("Abc", "Def", "American", "Phillipino"));

		Iterator<String> itr = listName.iterator();

		while (itr.hasNext())
		{
			if(itr.next().length() < 4) {
				itr.remove();
			}
			//System.out.println(itr.next());
		}
		
		System.out.println(listName);

	}

}
