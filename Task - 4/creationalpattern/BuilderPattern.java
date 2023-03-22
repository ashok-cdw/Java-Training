/*
 * Program describes the Builder Pattern
 * 
 * Static class returns new instance of outer class
 */

package creationalpattern;

public class BuilderPattern {

	public static void main(String[] args) {
		Mobile mob = new Mobile.MobileBuilder("128GB","6GB","Mediatek").add5gFeature().build();
		System.out.println(mob);
	}
}

class Mobile{
	private String RAM;
	private String HDD;
	private String CPU;
	private boolean is5gEnabled;
	
	private Mobile(MobileBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.CPU = builder.CPU;
		this.is5gEnabled = builder.is5gEnabled;
	}

	public static class MobileBuilder{
		private String HDD;
		private String RAM;
		private String CPU;
		private boolean is5gEnabled;
		
		public MobileBuilder(String HDD, String RAM, String CPU) {
			this.HDD = HDD;
			this.RAM = RAM;
			this.CPU = CPU;
		}
		
		public MobileBuilder add5gFeature() {
			this.is5gEnabled = true;
			return this;
		}
		
		public Mobile build() {
			return new Mobile(this);
		}
	}
	
	@Override
	public String toString() {
		return "CPU : " + this.CPU+ " \nHDD : "+this.HDD+" \nRAM : "+this.RAM+" \nis5gEnabled : "+this.is5gEnabled;
	}
}