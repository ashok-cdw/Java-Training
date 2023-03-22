
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
			while (true) {
				try {
					// DigitalClock.clock(date.getHours() + ":"+date.getMinutes() +
					// ":"+date.getSeconds());
					DigitalClock.clock(DateFormat.getTimeInstance().format(new Date()));
					Thread.sleep(1000);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if (i < 3) {
					i++;
					continue;
				} else {
					System.out.println("Do you want to continue..? Y for Yes | AnyKey for No");
					userOption = scan.nextLine().charAt(0);
					if (userOption == 'Y' || userOption == 'y') {
						return;
					} else {
						i = 1;
					}
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