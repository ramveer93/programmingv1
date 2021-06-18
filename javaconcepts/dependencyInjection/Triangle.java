package dependencyInjection;

public class Triangle implements IShape{

	@Override
	public void draw() {
		System.out.println("drawing triangle");
	}
}
