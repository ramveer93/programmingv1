package ImmutableClass;

public final class ImmutablDemo {
	private final String name;
	private final int number;

	public ImmutablDemo(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
	
	public static void main(String args[]) 
	{
		ImmutablDemo ed = new ImmutablDemo("abcd",10);
		System.out.println(ed.getName());
		System.out.println(ed.getNumber());
		
	}

}
