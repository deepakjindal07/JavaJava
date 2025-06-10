package random_7;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CountWordsInString {

	public static void main(String[] args) {
		String str = "Count this this this string123";

		String[] strArry = str.split(" ");

		System.out.println(LargestWordAndCount(strArry));

	}

	private static String LargestWordAndCount(String[] s) {

		Map<String, Integer> HStr = new HashMap<>();
		int temp = 0;

		for (String g : s)
		{
			if (HStr.containsKey(g))
			{
				HStr.put(g, (HStr.get(g) + 1));
			} else
			{
				HStr.put(g, 1);
			}
		}
		
		

		for (int n : HStr.values())
		{
			//System.out.println(n);
			if (temp < n)
			{
				temp = n;
			}

		}
		
		String highestWord = "";
        int highestCount = 0;
        
        // Find the word with the highest count
        for (Map.Entry<String, Integer> entry : HStr.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                highestWord = entry.getKey();
            }
        }

        return "Word: " + highestWord + ", Count: " + highestCount;
		//return temp;
	}

}
