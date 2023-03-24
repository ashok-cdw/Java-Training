/*
 * Program describes the visitor pattern 
 * 
 * Based on Object, Different functions will be called
 */
package behaviourpattern;

public class VisitorPattern {

	public static void main(String[] args) {
		VisitorImplementation visitor = new VisitorImplementation();

		Ashok ashok = new Ashok("Ashok", "Erode", "KEC");
		ashok.call(visitor);

		Harish harish = new Harish("Harish", "Hosur", "KEC");
		harish.call(visitor);
	}

}

interface Friends {
	public void call(Visitor visitor);
}

class Ashok implements Friends {
	String name;
	String city;
	String college;

	public Ashok(String name, String city, String college) {
		this.name = name;
		this.city = city;
		this.college = college;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String getCollege() {
		return this.college;
	}

	@Override
	public void call(Visitor visitor) {
		visitor.visit(this);
	}

}

class Harish implements Friends {
	String name;
	String city;
	String college;

	public Harish(String name, String city, String college) {
		this.name = name;
		this.city = city;
		this.college = college;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String getCollege() {
		return this.college;
	}

	@Override
	public void call(Visitor visitor) {
		visitor.visit(this);
	}

}

interface Visitor {
	void visit(Ashok ashok);

	void visit(Harish harish);
}

class VisitorImplementation implements Visitor {

	@Override
	public void visit(Ashok ashok) {
		System.out.println(ashok.name + " will use whatsapp");
		new WhatsApp();
	}

	@Override
	public void visit(Harish harish) {
		System.out.println(harish.name + " will use telegram");
		new Telegram();
	}

}

class WhatsApp {
	public WhatsApp() {
		System.out.println("WhatsApp Opened\n");
	}
}

class Telegram {
	public Telegram() {
		System.out.println("Telegram Opened\n");
	}
}