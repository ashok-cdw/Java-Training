/*
 * Program continuously incremented by 1 after 1 second 
 * after every 10 it prints something 
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DigitalClock {
	
	public DigitalClock() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				try {
					//	DigitalClock.clock(date.getHours() + ":"+date.getMinutes() + ":"+date.getSeconds());
					DigitalClock.clock(DateFormat.getTimeInstance().format(new Date()));
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}
	public static void main(String[] args) {
		new DigitalClock();
	}
	
	public static void clock(String time) {
		System.out.println(time);
	}
}