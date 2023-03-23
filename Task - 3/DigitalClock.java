
/*
 * Program continuously incremented by 1 after 1 second 
 * after every 10 it prints something 
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DigitalClock {
	int i = 1;
	char userOption;

	public DigitalClock() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Scanner scan = new Scanner(System.in);
		es.execute(() -> {
			long startTime = System.currentTimeMillis();
			while (true) {
				try {
					DigitalClock.clock(DateFormat.getTimeInstance().format(new Date()));
					Thread.sleep(1000);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if (!(System.currentTimeMillis() - startTime < 3600 * 1000)) {
					System.out.println("Exited...");
					return;
				}

			}
		});
		es.shutdown();
	}

	public static void main(String[] args) {
		new DigitalClock();
	}

	public static void clock(String time) {
		System.out.println(time);
	}
}