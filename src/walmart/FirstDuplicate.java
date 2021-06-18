package walmart;

import java.util.LinkedHashSet;
import java.util.Set;

public class FirstDuplicate {
	public static void main(String args[]) {
		int a[] = { 1, 4, 2, 4, 5, 2,1};
		System.out.println(firstDuplicate(a));
		
		System.out.println(firstDuplicateWithoutSpace(a));

	}

	private static int firstDuplicate(int a[]) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (!set.add(a[i])) {
				return a[i];
			}
		}
		return 0;
	}

	private static int firstDuplicateWithoutSpace(int a[]) {

		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i])] >= 0) {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			} else {
				return Math.abs(a[i]);
			}
		}
		return 0;
	}

}
