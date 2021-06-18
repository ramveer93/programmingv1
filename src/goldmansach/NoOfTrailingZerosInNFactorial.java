package goldmansach;


/*
 * https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 * 
 * 	Input: n = 5
	Output: 1 
	Factorial of 5 is 120 which has one trailing 0.

	Input: n = 20
	Output: 4
	Factorial of 20 is 2432902008176640000 which has
	4 trailing zeroes.

	Input: n = 100
	Output: 24


Trailing 0s in n! = Count of 5s in prime factors of n!
                  = floor(n/5) + floor(n/25) + floor(n/125) + ....
                  
 */
public class NoOfTrailingZerosInNFactorial {
	
	public static void main(String args[]) {
		System.out.println("Trailing zeros in n! -->"+countTrailingZeros(100));
		
		
	}
	
	
	private static int countTrailingZeros(int n) {
		int count = 0;
		for(int i=5;i<=n; i = i*5) {
			count+=n/i;
		}
		return count;
		
	}

}
