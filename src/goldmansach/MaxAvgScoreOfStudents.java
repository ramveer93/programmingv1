package goldmansach;

import java.util.ArrayList;
import java.util.List;

public class MaxAvgScoreOfStudents {
	public static void main(String args[]) {
		Student student1 = new Student();
		student1.setName("A");
		List<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(30);
		list.add(10);
		student1.setScores(list);
		
		Student student2 = new Student();
		student2.setName("B");
		list.clear();
		list.add(100);
		list.add(50);
		list.add(10);
		student2.setScores(list);
		List<Student> l = new ArrayList<>();
		l.add(student1);
		l.add(student2);
		maxAvg(l);
	}
	private static void maxAvg(List<Student> list){
		int avg = 0;
		String studentName = null;
		for(Student std : list){
			int maxAvg = 0;
			List<Integer> scores = std.getScores();
			int score = 0;
			
			for(Integer i : scores) {
				score+=i;
			}
			maxAvg = score/scores.size();
			if(maxAvg>avg) {
				avg = maxAvg;
				studentName = std.getName();
			}
		}
		System.out.println("student : "+studentName+" has max avg : "+avg);
		
	}

}
