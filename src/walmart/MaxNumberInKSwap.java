package walmart;

/**
 * https://www.youtube.com/watch?v=5crucASFoA4
 * 
 * @author sramveer
 *
 */
public class MaxNumberInKSwap {

	static String maxNumber;

	public static void main(String args[]) {
		String s = "254";
		maxNumber = s;
		max(s, 1);
		System.out.println("------kkk---" + maxNumber);

	}

	private static String swap(String str, int i, int j) {
		/**
		 * abc -> d-> efg->h kl
		 * 
		 */
		char ith = str.charAt(i);
		char jth = str.charAt(j);
		String first = str.substring(0, i);
		String middle = str.substring(i + 1, j);
		String last = str.substring(j+1);

		return first + jth + middle + ith + last;

	}

	private static void max(String str, int k) {
		
		if(Integer.parseInt(maxNumber)<Integer.parseInt(str)) 
		{
			maxNumber = str;
		}
		if (k == 0) {
			return;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) > str.charAt(i)) {
					str = swap(str, i, j);
					max(str, k - 1);
					str = swap(str, i, j);

				}

			}

		}

	}
}
