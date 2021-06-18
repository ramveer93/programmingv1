package walmart;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * @author sramveer
 *
 */
public class MatchingParamthesis 
{
	public static void main(String args[])
	{
		System.out.println(new MatchingParamthesis().IsBalanced("[{)]"));
	}
	/**
	 * [{}]
	 * @param s
	 * @return
	 */
	private boolean IsBalanced(String s){
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[')
			{
				stack.push(c);
				
			}else {
				char incoming = stack.pop();
				if(c == '}' && incoming == '[' || c == '}' && incoming == '(')
				{
					return false;
				}
				if(c == ']' && incoming == '{' || c == ']' && incoming == '(')
				{
					return false;
				}
				if(c == ')' && incoming == '[' || c == ')' && incoming == '{')
				{
					return false;
				}
			}
			
		}
		return stack.isEmpty();
		
	}

}
