package invquestions_athenahealth_hiring;

import java.util.HashMap;
import java.util.Map;

public class Athens {
	public static void main(String args[]) {

		Map<Integer, Character> map = new HashMap<Integer, Character>();
		map.put(0, 'A');
		map.put(1, 'T');
		map.put(2, 'H');
		map.put(3, 'E');
		map.put(4, 'N');
		map.put(5, 'S');
		System.out.println(athenaEncoding(4440, map));

	}

	private static String athenaEncoding(int n, Map<Integer, Character> map) {
		int i = 0;
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			sb = sb.append(map.get(n % 6));
			n = n / 6;
		}
		return sb.reverse().toString();
	}

}
