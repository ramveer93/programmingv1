package goldmansach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxNoUsingStrings {

	public static void main(String args[]) {
		List list = new ArrayList<>();
		list.add("54");
		list.add("546");
		list.add("548");
		list.add("60");
		
		MaxNoUsingStrings obj = new MaxNoUsingStrings();
		
		System.out.println(obj.getBiggestNo(list));

	}

	private  String getBiggestNo(List<String> ar) {
		Collections.sort(ar, new mycomparator());
		Iterator itr = ar.iterator();
		StringBuffer sb = new StringBuffer();
		while (itr.hasNext()) {
			sb.append(itr.next());
		}
		return sb.toString();
	}

	class mycomparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			String x = o1.toString();
			String y = o2.toString();
			String xy = x + y;
			String yx = y + x;
			return xy.compareTo(yx) > 0 ? -1 : 1;
		}

	}

}
