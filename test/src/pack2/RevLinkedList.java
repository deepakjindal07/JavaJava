package pack2;

import java.util.LinkedList;
import java.util.List;

public class RevLinkedList {

	public static void main(String[] args) {
		int[] ch = { 1, 2, 3, 4, 5, 6, 7 };

		List<Integer> list = new LinkedList<>();
		for (int x : ch)
		{
			list.add(x);
		}
		
		System.out.println(list.reversed());

	}

}
