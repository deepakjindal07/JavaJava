package collections;

import java.io.IOException;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) throws IOException {
		int size = 5;

		ArrayList<Integer> arrlt = new ArrayList<>(size);

		for(int i = 1; i < size; i++){
			arrlt.add(i);
		}

		System.out.println(arrlt);

		arrlt.remove(3);
		System.out.println(arrlt);

		for (Integer element : arrlt) {
			System.out.println(element + " ");
		}

	}

}
