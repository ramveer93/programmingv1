package dependencyInjection;

public class DrawShape {

	/***
	 * Addvantage of this is there is no tightly coupling 
	 * with shape object we dont have to initialize the triangle or circle object 
	 * but we are injecting the dependency by using setShape method 
	 */
	private IShape shape;

	public void setShape(IShape shape) {
		this.shape = shape;
	}
	public void drawShape() {
		this.shape.draw();
	}
}
