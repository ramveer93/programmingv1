package goldmansach;

import java.util.HashMap;

public class SubArraySumExactlyEqualToK {
	public static void main(String args[]) {
		int arr[] = { 10, 2, -2, -20, 10 };  
        int sum = -10;  
        
        noOfSubArrays(arr,sum);
	}

	
	private static void noOfSubArrays(int a[], int k) {
		int result = 0;
		int currentSum = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<a.length;i++) {
			currentSum+=a[i];
			if(currentSum == k ) {
				result++;
			}
			
			if(map.containsKey(currentSum-k)) {
				result+=map.get(currentSum-k);
			}
			
			Integer count = map.get(currentSum);
			if(count==null) {
				map.put(currentSum, 1);
			}else {
				map.put(currentSum, count+1);
			}
		}
	System.out.println("   Result: "+result);
		
	}
}
