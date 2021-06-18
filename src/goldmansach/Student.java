package goldmansach;

import java.util.List;

public class Student {
	private String name;
	private List<Integer> scores;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", scores=" + scores + "]";
	}
	

	

}
