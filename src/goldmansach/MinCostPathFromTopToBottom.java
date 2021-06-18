package goldmansach;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * 
 * @author sramveer
 *
 */
public class MinCostPathFromTopToBottom {
	public static void main(String args[]) {

		int a[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println("" + minCostPath(a, 2, 2));
		System.out.println("" + dp(a, 2, 2));
	}

	public static int minCostPath(int a[][], int rows, int columns) {
		if (rows < 0 || columns < 0)
			return Integer.MAX_VALUE;
		else if (rows == 0 && columns == 0) {
			return a[rows][columns];
		} else {
			int t1 = minCostPath(a, rows - 1, columns - 1);
			int t2 = minCostPath(a, rows - 1, columns);
			int t3 = minCostPath(a, rows, columns - 1);
			int minFromThree = min(t1, t2, t3);
//			System.out.println("-------path-------"+minFromThree);
			return a[rows][columns] + minFromThree;

		}
	}

	public static int dp(int a[][], int r, int c) {
		int m[][] = new int[r + 1][c + 1];
		m[0][0] = a[0][0];

		/**
		 * fill first row
		 */
		for (int i = 1; i <= r; i++) {
			m[i][0] = m[i - 1][0] + a[i][0];

		}
		/**
		 * fill first row
		 */
		for (int j = 1; j <= c; j++) {
			m[0][j] = m[0][j - 1] + a[0][j];

		}

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				m[i][j] = a[i][j] + min(m[i - 1][j], m[i - 1][j - 1], m[i][j - 1]);
			}
		}
		return m[r][c];

	}

	private static int min(int x, int y, int z) {
		if (x < y) {
			return x < z ? x : z;
		} else
			return (y < z) ? y : z;
	}
}
