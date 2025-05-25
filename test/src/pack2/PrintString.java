package pack2;

public class PrintString {

	public static void main(String[] args) {
		String str = "1[d]2[e]1[p]"; // deep

		char[] chStr = str.toCharArray();

		StringBuilder result = new StringBuilder();

		//Run program as many times as lenght of string, iterate through each character. 
		for (int i = 0; i < chStr.length; i++)
		{
			int Times;
			
			// If its a Number, get its value, and move to next place. 
			if (Character.isDigit(chStr[i]))
			{
				// Get number value;
				Times = Character.getNumericValue(chStr[i]);
				i++;

				if (str.charAt(i) == '[' && str.charAt(i + 2) == ']')
				{
					char letter = str.charAt(i + 1);
					result.append(String.valueOf(letter).repeat(Times));
					i += 2; // Move past ']'
				}

			}

		}
		System.out.println("Final String " + result);
	}

}
