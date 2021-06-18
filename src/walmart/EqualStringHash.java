package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * 
 * 
 * 
 * @author sramveer
 * 
 *         given s1 = ab#c , s2= ab#d find out if they are equal or not
 */

public class EqualStringHash {

	public static void main(String args[]) {
		System.out.println("--------------------");

		System.out.println(new EqualStringHash().IsEqualStr("a#bc", "a#cb"));
	}

	private boolean IsEqualStr(String s1, String s2) {
//		Arrays.sort(s1.toCharArray());
//		Arrays.sort(s2.toCharArray());
		
		
//		Collections.sort(new ArrayList<>(),new MyComparator());

		return build(s1).equals(build(s2));
	}

	private String build(String s) {
		Stack<Character> stack = new Stack();
		
		for (char c : s.toCharArray()) {
			if (c != '#') {
				stack.push(c);
			}
//			else if(!stack.isEmpty())
//			{
//				stack.pop();
//				
//			}
		}
		char[] cc = stack.toString().toCharArray();
		Arrays.sort(cc);
		String str = new String(cc);
		System.out.println("================ss"+str);
		return str;
	}
	
	class MyComparator implements Comparator<String>{

		
		@Override
		public int compare(String s1, String s2) 
		{
//			ascending
			return s1.compareTo(s2);
//			s2.compareTo(s1)--> descending 
			
		}
	}

}
