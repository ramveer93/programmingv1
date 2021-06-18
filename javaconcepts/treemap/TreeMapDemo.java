package treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String args[]) {
		Map<Integer, String> map = new TreeMap<>(new MyComparator());
		map.put(101, "Value");
		map.put(34, "Report");
		map.put(392, "add");
		map.put(2, "rurie");
		map.put(1234, "9jjk");

		System.out.println("nap " + map);
	}

}

class MyComparator implements Comparator {
//	public int compare(Integer a, Integer b) {
//		return b.compareTo(a);
//	}

	@Override
	public int compare(Object o1, Object o2) {
		int a = (Integer) o1;
		int b = (Integer) o2;
		if (a > b) {
			return -1;
		} else
			return 1;
	}
}
