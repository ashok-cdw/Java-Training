/*
 * Program describes the Bridge Pattern
 * 
 * Class consists of member which is a reference (bridge) to another class/interface
 */
public class BridgePattern {

	public static void main(String[] args) {
		new Square(new Blue()).draw();
		new Circle(new Blue()).draw();
	}
}


interface Color{
	public String fill();
}

class Blue implements Color{
	public String fill() {
		return "Blue Color....";
	}
}

abstract class Shape{
	Color color;
	public abstract void draw();
}

class Square extends Shape{
	public Square(Color color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("Square Shape Drawn : " + color.fill());
	}
	
}

class Circle extends Shape{
	public Circle(Color color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("Circle Shape Drawn : " + color.fill());
	}
	
}