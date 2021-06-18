package Polymorphism;

public class OperatorOverloading 
{

	static String operator(String s, String n) 
	{
		String f = s+n;
		return f;
	}
	static int operator(int a, int b)
	{
		int c = a+b;
		return c;
	}
	public static void main(String args[]) 
	{
		
		System.out.println(operator("Ramveer", "Tanu"));
		System.out.println(operator(10,11));
	}
}
