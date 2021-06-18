package walmart;

import java.util.Comparator;

public class MyCustomComparator implements Comparator<Character>
{
	@Override
	public int compare(Character c, Character s) 
	{
		return -c.compareTo(s);
		
	}
	

}
