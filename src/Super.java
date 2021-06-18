
public class Super {
	static void f() {
		System.out.println("super fo");
	}
	
	public static void main(String[] args) {
		Super s = new subClass();
		s.f();
	}
}

class subClass extends Super{
	static void f() {
		System.out.println("sub");
	}
}
