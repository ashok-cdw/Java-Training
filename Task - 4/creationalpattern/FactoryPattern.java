/*
 * Program describes the Factory Pattern
 * 
 * Based on user input, instance of various classes are created 
 */
package creationalpattern;

public class FactoryPattern {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("8gb", "1tb", "ryzen 7");
		System.out.println(pc);

		Computer server = ComputerFactory.getServer("8gb", "1tb", "ryzen 7");
		System.out.println(server);
	}
}

interface Computer {

	public abstract String getRAM(String ram);

	public abstract String getHDD(String hdd);

	public abstract String getProcessor(String processor);
}

class Pc implements Computer {

	private String ram;
	private String hdd;
	private String processor;

	public Pc(String ram, String hdd, String processor) {
		this.ram = ram;
		this.hdd = hdd;
		this.processor = processor;
	}

	@Override
	public String getRAM(String ram) {
		return this.ram;
	}

	@Override
	public String getHDD(String hdd) {
		return this.hdd;
	}

	@Override
	public String getProcessor(String processor) {
		return this.processor;
	}

	@Override
	public String toString() {
		return "Computer :" + this.ram + " " + this.hdd + " " + this.processor;
	}
}

class Server implements Computer {

	private String ram;
	private String hdd;
	private String processor;

	public Server(String ram, String hdd, String processor) {
		this.ram = ram;
		this.hdd = hdd;
		this.processor = processor;
	}

	@Override
	public String getRAM(String ram) {
		return this.ram;
	}

	@Override
	public String getHDD(String hdd) {
		return this.hdd;
	}

	@Override
	public String getProcessor(String processor) {
		return this.processor;
	}

	@Override
	public String toString() {
		return "Server :" + this.ram + " " + this.hdd + " " + this.processor;
	}
}

class ComputerFactory {
	public static Computer getComputer(String ram, String hdd, String processor) {
		return new Pc(ram, hdd, processor);
	}

	public static Computer getServer(String ram, String hdd, String processor) {
		return new Server(ram, hdd, processor);
	}
}