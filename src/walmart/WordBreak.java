package walmart;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/word-break-problem-dp-32/
 * @author sramveer
 *
 */

public class WordBreak
{
	private static Set<String> set = new HashSet<>();
	public static void main(String args[]) 
	{
		 String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                 "man","mango","icecream","and",  
                 "go","i","like","ice","cream"}; 
		 
		 for(String s: temp_dictionary) 
		 {
			 set.add(s);
			 
		 }
		 System.out.println(wordBreak("ilikesamsun"));
		 
		
	}
	
	private static boolean wordBreak(String s)
	{
		if(s.length() ==0) {
			return true;
		}
		for(int i=1;i<=s.length();i++)
		{
			if(set.contains(s.subSequence(0, i)) && wordBreak(s.substring(i,s.length()))) {
				return true;
			}
			
			
		}
		 return false;
		
	}
	

}
