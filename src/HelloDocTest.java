
/**
 * Given a set of items, each with a weight and a value and we need to determine
 * the number of each item to include in a collection so that the total weight
 * is less than or equal to a given limit and the total value is as large as
 * possible. Input: value = [ 20, 5, 10, 40, 15, 25 ] weight = [ 1, 2, 3, 8,
 * 7,4] int W = 10
 *
 */
public class HelloDocTest {

	private static int[][] dp;

	public static void main(String[] args) {
		int val[] = { 20, 5, 10, 40, 15, 25 };
		int wt[] = { 1, 2, 3, 8, 7, 4 };
		int w = 10;
		int n = val.length;
		System.out.println(new HelloDocTest().recursion(val, wt, w, n));
		System.out.println(new HelloDocTest().dpSolution(val, wt, w, n));
		
		
	}

	public int recursion(int val[], int wt[], int w, int n) {
		if (n == 0 || w == 0) {
			return 0;
		}
		if (wt[n - 1] <= w) {
			int include = val[n - 1] + recursion(val, wt, w - wt[n - 1], n - 1);
			int dontInclude = recursion(val, wt, w, n - 1);
			return Math.max(include, dontInclude);
		} else { // wt[n-1]>w
			return recursion(val, wt, w, n - 1);
		}

	}

	public int dpSolution(int val[], int wt[], int w, int n) {
		int dp[][] = new int[n + 1][w + 1];// i is n and j is w
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;

				}

			}

		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}

		}
		return dp[n][w];
	}

}
