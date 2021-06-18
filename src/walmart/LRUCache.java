package walmart;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://www.youtube.com/watch?v=S6IfqDXWa10
 * 
 * @author sramveer
 * 
 * 
 *         put -> add at the front get -> add at the front update-> put-> add at
 *         the front out of space -> so we have to delete : -> delete from the
 *         tail of the doubly LL and put in front for O(1) get : use hashtable
 *         for O(1) put : use Doubly linked list
 * 
 *
 */
public class LRUCache {

	private Deque<Integer> deque;
	private HashSet<Integer> set;
	private int SIZE;

	LRUCache(int capecity) {
		this.SIZE = capecity;
		this.deque = new LinkedList<>();
		this.set = new HashSet<>();
	}

	private void refer(int n) {
		/**
		 * two cases if the number not exists in the deque: -> check if the queue is
		 * full -> remove last and add
		 */
		if (!set.contains(n)) {
			if (deque.size() == SIZE) {
				int number = deque.removeLast();
				set.remove(number);
				deque.push(n);
				set.add(n);
			} else {
				deque.push(n);
				set.add(n);
			}
		} else {
			deque.remove(n);
			deque.push(n);
			set.add(n);
		}
	}
	
	
	
	
	
	
}
