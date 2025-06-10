package random_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RemDups {

	public static void main(String[] args) {
		int[] in = { 1, 2, 2, 4, 5, 6, 7 };

		ArrayList<Integer> arl = new ArrayList<>();

		for (int i = 0; i < in.length; i++)
		{
			arl.add(in[i]);
		}

		Collections.sort(arl);
		
		StringBuilder stb = new StringBuilder(arl.toString());
		char x = stb.charAt(stb.length()-5);
		
		System.out.println(x);
		
		//Set<Integer> CleanListIn = new HashSet<>(arl);
		//System.out.println(CleanListIn.toString());

	}

}
