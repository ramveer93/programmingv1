
/**
 * Given a list containing future predictions of share prices, find maximum
 * profit that can be earned by buying and selling shares at most twice with a
 * constraint that a new transaction can only start after the previous
 * transaction is complete. i.e. we can only hold at most one share at a time.
 * 
 * Input: Stock Prices are {2, 4, 7, 5, 4, 3, 5}
 *
 * 
 */
public class HelloDocTest2 {

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 7 };
		System.out.println(new HelloDocTest2().shareBuySell(a, a.length));
	}

	public int shareBuySell(int a[], int n) {
		if (n == 0)
			return 0;
		int b1 = Integer.MAX_VALUE; // buy at min price
		int p1 = 0; // sell at max price
		int b2 = Integer.MAX_VALUE;
		int p2 = 0;
		

		for (int i = 0; i < n; i++) {
			b1 = Math.min(b1, a[i]);
			p1 = Math.max(p1, a[i] - b1);
			b2 = Math.min(b2, a[i]-p1);
			p2 = Math.max(p2, a[i] - b2);
		}
		return p2;

	}
}
