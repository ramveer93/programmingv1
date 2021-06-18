package Polymorphism;
/**
 * https://www.geeksforgeeks.org/polymorphism-in-java/
 * @author sramveer
 *
 */

public class CompileTimePoly 
{

	static int doSomething(int a) 
	{
		return a*10;
		
	}
	
	static float doSomething(int a, float b) 
	{
		return a*b;
		
	}
	
	static String doSomething(String s) 
	{
		
		return "HH"+s;
	}
	static double doSomething(double d) 
	{
		return d*10;
	}
	/**
	 * in method overloading: except method name we can change anything
	 * we can have different return type , different number of parameters, different type of parameters
	 */
	
	public static void main(String args[])
	{
		System.out.println(doSomething(10));
		System.out.println(doSomething(10,15.0f));
		System.out.println(doSomething("sramveer"));
		System.out.println(doSomething(10.20));
		
		
		
	}
}
