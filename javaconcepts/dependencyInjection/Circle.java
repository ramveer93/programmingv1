package dependencyInjection;

public class Circle implements IShape{

	@Override
	public void draw() {
		System.out.println("drawing circle");
	}
}
