/*
 * Program describes the Singleton Pattern
 * 
 * only one object can be created for a class
 */
package creationalpattern;

public class SingletonPattern {

	public static void main(String[] args) {
		new Thread(()->{
			TicketCounter.getInstance().getTicket();
		}).start();
		new Thread(()->{
			TicketCounter.getInstance().getTicket();
		}).start();
		new Thread(()->{
			TicketCounter.getInstance().getTicket();
		}).start();
	}
}

class TicketCounter{
	private static TicketCounter obj;
	private TicketCounter() {
		System.out.println("Ticket Counter");
	}
	synchronized static TicketCounter getInstance() {
		if(obj==null) {
			obj = new TicketCounter();
		}
		return obj;
	}
	
	void getTicket() {
		System.out.println("Ticket");
	}
}