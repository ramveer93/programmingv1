package walmart;

public class RunningSum 
{

	public static void main(String args[]) 
	{
		
		int a[] = {-5, 4, -2, 3, 1, -1, -6, -1, 0, 5};
		System.out.println(runningSum(a));
		
	}
	private static int runningSum(int a[])
	{
		int sum = 0;
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i];
		}
		/**
		 * x+sum>=1
		 * x >= 1+sum
		 */
		return sum>0?1-sum:1+sum;
		
	}
}
