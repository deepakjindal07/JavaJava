package random_5;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupCh {

	public static void main(String[] args) {
		String str = "aabbccddeaa"; 
		char[] ch = str.toCharArray(); 
		
		Set<Character> hs = new LinkedHashSet<>(); 
		for(char c:ch) {
			hs.add(c);			
		}
		
		StringBuilder sb = new StringBuilder(); 
		for( Character c:hs) {
			//System.out.print(c.toString());
			sb = sb.append(c.toString()); 
			
		}
		sb.append("a");
		System.out.println(sb);

	}
}
