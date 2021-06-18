package invquestions_athenahealth_hiring;
//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
public class MatrixTraversal {
	
	public static void main(String args[]) {
		int R = 3;
		int C = 6;
		int a[][] = {{1,2,3,4,5,6},
				{7,8,9,10,11,12},
				{13,14,15,16,17,18}
		};
		printMatrixInSpiral(3,6,a);
	}
	
	public static void printMatrixInSpiral(int m, int n, int a[][]) {
		/**
		 * k = starting row index
		 * m = ending row index
		 * l = starting column index
		 * n = ending column index
		 */
		int k = 0;
		int l = 0;
		
		while(k<m && l<n) {
			//first print the 
			for(int i=l;i<n;i++) {
				System.out.println(" "+a[k][i]);
			}
			k++;
			
			//print from top to bottom
			for(int i=k;i<m;i++) {
				System.out.println(" "+a[i][n-1]);
			}
			n--;
			
			if(k<m) {
				//print from right to left
				for(int i=n-1;i>=l;i--) {
					System.out.println(" "+a[m-1][i]);
				}
				m--;
			}
			
			if(l<n) {
				//print from bottom to top
				for(int i=m-1;i>=k;i--) {
					System.out.println(" "+a[i][l]);
					
				}
				l++;
			}
		
			
		}
	}
	
//	public static int   minCostPath(int a[][], int r, int c) {
//		if(r<0 || c<0) 
//		{
//			return Integer.MAX_VALUE;
//			
//		}else if(r==0 || c==0) {
//			return a[r][c];
//		}
//		
//		
//	}
	

}
