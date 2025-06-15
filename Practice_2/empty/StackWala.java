package empty;

import java.util.Stack;

public class StackWala {

	public static void main(String[] args) {

		String str = "({[})";
		boolean isBalanced = true;

		Stack<Character> stk = new Stack<>();

		for (char c : str.toCharArray())
		{
			{

				if (c == '(' || c == '{' || c == '[')
				{
					stk.push(c);
				} else if (c == ')' || c == '}' || c == ']')
				{
					// System.out.println("something");
					if (stk.isEmpty())
					{
						isBalanced = false;
						break;
					}

					char top = stk.pop();
					if (Matching(top, c))
					{
						isBalanced = true;
						break;

					}

				}
			}

		}

		System.out.println(isBalanced);
	}

	private static boolean Matching(char open, char close) {
		return (open == '(' && close == ')') || 
				(open == '{' && close == '}') || 
				(open == '[' && close == ']');
	}
}
