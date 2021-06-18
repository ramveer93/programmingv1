package staticDynamicBinding;

public class Animal 
{
	void eat() {
		System.out.println("Animal eating....");
	}
	public static void main(String args[])
	{
		Dog d = new Dog();//static/early/compile binding
		d.eat();
		
		Animal a = new Animal();//static/early/compile binding
		a.eat();
		
		Animal an = new Dog();//dynamic binding -> an is an instance of animal in compile time , but it is instance of dog in run time
		an.eat();// why dog eating because on run time the instance is of dog instance so it will call the eat method of dog class
		
		//Dog dg = new Animal(); //parent class can contain the instance of child class, but child class can't contain the instance of parent class, hence compilation error
		
		
		
	}

}
class Dog extends Animal{
	void eat() {
		System.out.println("Dog eating");
	}
	
}
