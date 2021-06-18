package walmart;

public class PrintSubstringsOfGivenString 
{

	public static void main(String args[]) 
	{
		allSubstrings("ADOBECODEBANC");
		
		System.out.println(substr("abcd", 0,3)+"---------"+"abcd".substring(0,3));
		
		
	}
	
	static void allSubstrings(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			for(int j = i+1;j<=s.length();j++)
			{
				System.out.println(s.substring(i,j));
				//System.out.println(""+substr(s,i,j));
				
			}
			
		}
		
	}
	private static String substr(String s, int i, int j)
	{
		char a[] = s.toCharArray();
		String output = "";
		for(int m = i;m<j;m++) {
			output = output+a[m];
		}
		return output;
	}
}
