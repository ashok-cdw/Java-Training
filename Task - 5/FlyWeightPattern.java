/*
 * Program describes the FlyWeight Pattern
 * 
 * Only one instance for an class should be created and returned 
 * New instance should be created only in case when different attributes are passed
 * Otherwise it should be returned from hashmap
 * 
 */

import java.util.HashMap;

public class FlyWeightPattern {
	public static void main(String[] args) {
		Paper.getPaper(new White());
		Paper.getPaper(new White());
		Paper.getPaper(new White());
		Paper.getPaper(new Grey());
		Paper.getPaper(new Grey());
	}
}

class Paper {
	static HashMap<String, Paper> map = new HashMap<>();
	PaperColor color;

	public Paper(PaperColor color) {
		this.color = color;
	}

	public static Paper getPaper(PaperColor color) {
		if (map.get(color.getColor()) != null) {
			System.out.println("Old Paper Object Returned With Color : " + color.getColor());
			return map.get(color.getColor());
		} else {
			System.out.println("New Paper Object Returned With Color : " + color.getColor());
			Paper paper = new Paper(color);
			map.put(color.getColor(), paper);
			return paper;
		}
	}
}

abstract class PaperColor {
	String name;

	public abstract String getColor();
}

class White extends PaperColor {
	String name = "White";

	@Override
	public String getColor() {
		return name;
	}
}

class Grey extends PaperColor {
	String name = "Grey";

	@Override
	public String getColor() {
		return name;
	}
}