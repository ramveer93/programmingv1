package dependencyInjection;

public class TestClass {

	public static void main(String[] args) {
		Circle circle = new Circle(); //problem is it is tightly couple with circle dependency
		Triangle triangle = new Triangle();
		circle.draw();
		triangle.draw();
		
		
		//using polymorphism
		System.out.println("-----> using polymorphism--------------<");
		IShape shape = new Circle();//parent class object can hold child object
		shape.draw();
		IShape triangleShape = new Triangle();
		triangleShape.draw();
		//problem with this is also dependency with triangle and circle class
		// it is tightly coupled with circle and trianlge class
		
		
		DrawShape drawShape  = new DrawShape();
		drawShape.setShape(triangleShape);
		drawShape.drawShape();
		
		drawShape.setShape(shape);
		drawShape.drawShape();
	}
}
