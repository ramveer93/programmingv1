package walmart;

/**
 * https://www.youtube.com/watch?v=GO5QHC_BmvM
 * 
 * @author sramveer
 *
 */
public class AllPossiblePathsFromTopToBottom
{
	public static void main(String args[]) 
	{
		System.out.println(allPathsBruteForce(2,3));
		System.out.println(allPathsDP(2,3));
	}
	
	private static int allPathsBruteForce(int n, int m)
	{
		if(n==1 || m==1)
		{
			return 1;
			
		}
		else {
			return allPathsBruteForce(n-1,m)+allPathsBruteForce(n,m-1);
		}
	}
	
	private static int allPathsDP(int m, int n) {
		int a[][] = new int[m][n];
		for(int i=0;i<m;i++)
		{
			a[i][0] = 1;
			
		}
		for(int j=0;j<n;j++)
		{
			a[0][j] = 1;
			
		}
		
		for(int i=1;i<m;i++) {
			for(int j = 1;j<n;j++)
			{
				a[i][j] = a[i-1][j]+a[i][j-1];
				
			}
		}
		return a[m-1][n-1];
	}

}
