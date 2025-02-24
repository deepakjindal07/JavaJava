package interview;

import java.util.HashMap;
import java.util.Map;

public class NonRep2 {

	public static void main(String[] args) {
		String str = "swiss";
		char[] ch = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for (char c : ch)
		{
			hm.put(c,hm.getOrDefault(c, 0)+1);
		}

			for(Map.Entry<Character, Integer> X : hm.entrySet()) {
				//System.out.println(X.getKey() + " - " + X.getValue());
				if (X.getValue() ==1) {
					System.out.println(" First non rep: "+X.getKey()+" - "+X.getValue());
					break;
				}
			}
	}
}
