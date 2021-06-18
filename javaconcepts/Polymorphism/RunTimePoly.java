package Polymorphism;

public class RunTimePoly {
	public static void main(String args[]) {
		RunTimePoly p = new Child();
		//p.print();
		p.p();

		RunTimePoly p1 = new Child2();
		//p1.print();
		p.p();
		
	}

	void print() {
		System.out.println("parent class print.....");
	}

	Object p() {
		System.out.println("parent object ...");
		return new Object();
	}

}

class Child extends RunTimePoly {

	void print() {
		System.out.println("child1 class print....");
	}

	String p() {
		System.out.println("child1 string");
		return "child1 string..";
	}

}

class Child2 extends RunTimePoly {
	void print() {
		System.out.println("child2 class print...");
	}

	Integer p() {
		System.out.println("child2 int ");
		return 90;
	}
}
