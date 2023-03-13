interface CalcArea {
	public double calcArea();
}

interface CalcVolume {
	public double calcVolume();
}

class Circle implements CalcArea, CalcVolume {
	private double radius;
	private double pi = 3.14;

	public Circle(double radius) {
		System.out.println("Circle");
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		double area = this.pi * this.radius * this.radius;
		return area;
	}

	@Override
	public double calcVolume() {
		double volume = (4 / 3) * this.pi * (this.radius * this.radius * this.radius);
		return volume;
	}
}

class Square implements CalcArea, CalcVolume {
	private double area;

	public Square(double area) {
		System.out.println("Square");
		this.area = area;
	}

	@Override
	public double calcArea() {
		double area = this.area * this.area;
		return area;
	}

	@Override
	public double calcVolume() {
		double volume = this.area * this.area * this.area;
		return volume;
	}
}

class Triangle implements CalcArea {
	private double a, b, c;

	public Triangle(double a, double b, double c) {
		System.out.println("Triangle");
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double calcArea() {
		double area = (this.a + this.b + this.c) / 2;
		return area;
	}

}

public class Shapes {
	public static void main(String[] args) {
		Circle circle = new Circle(12);
		System.out.println("Area : " + Math.round(circle.calcArea()) + " sq. cm");
		System.out.println("Volume : " + Math.round(circle.calcVolume()) + " cubic units");

		System.out.println("---------------------------------");
		
		Square square = new Square(12);
		System.out.println("Area : " + Math.round(square.calcArea()) + " sq. cm");
		System.out.println("Volume : " + Math.round(square.calcVolume()) + " cubic units");

		System.out.println("---------------------------------");
		
		Triangle triangle = new Triangle(10,20,10);
		System.out.println("Area : " + Math.round(triangle.calcArea()) + " sq. cm");
	}
}
