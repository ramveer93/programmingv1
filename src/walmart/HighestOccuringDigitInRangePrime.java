package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HighestOccuringDigitInRangePrime {
	
	private static boolean arr[] = new boolean[10000001];

	public static void main(String args[]) {

		System.out.println("----" + IsPrime(1101));
		
	
//		
	//System.out.println(primeInRange(2,20));
		Arrays.fill(arr, true);
		for(int p=2;p<=Math.sqrt(1000000);p++) 
		{
			for(int i = p*p;i<=1000000;i=i+p) {
				
					arr[i] = false;
			}
			
		}
		
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		while(t-->0) 
		{
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(primeInRange(l,r));
			
		}
	}

	private static int primeInRange(int l, int r) {
		List<String> result = new ArrayList<String>();

		for (int i = l; i <= r; i++) {

			if (arr[i]) {
				result.add(String.valueOf(i));
			}
		}
		
		return highOccuranceDigit(result);
	}

	private static int highOccuranceDigit(List<String> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for (String s : list) {
			for (int i = 0; i < s.length(); i++) {
				int c = Character.getNumericValue(s.charAt(i));
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
		}
		int maxDigit = 0;
		int maxCount = 0;
		int maxDigitFinal = 0;
		int maxCountFinal = 0;
		
//		Object[] values = map.values().toArray();
//		for(int i=0;i<values.length-1;i++) 
//		{
//			if(values[i]!= values[i+1])
//			{
//				break;
//			}
//		
//			
//		}
		
		for(Entry<Integer,Integer> entry: map.entrySet()) 
		{
			maxDigit = entry.getKey();
			maxCount = entry.getValue();
//			if(maxCountFinal == maxCount ) 
//			{
//				maxCountFinal = Math.max(a, b)
//				
//			}
			if(maxCountFinal<=maxCount)
			{
				maxCountFinal = maxCount;
				maxDigitFinal = maxDigit;
			}
		}
		return maxDigitFinal;
	}

	static boolean IsPrime(int n) {
		for (int i = 2; i < Math.sqrt(n); i = i+2) {
			if (n % i == 0) {
				return false;

			}

		}
		return true;
	}
}
