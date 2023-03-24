/*
 * Program continuously incremented by 1 after 1 second 
 * after every 10 it prints something 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountingThread {
	public CountingThread() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(() -> {
			try {
				for (int i = 1; i <= 100;i++) {
					Counter.increment(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		es.shutdown();
	}

	public static void main(String[] args) {
		new CountingThread();
	}

}

class Counter {
	static int count;

	static void increment(int value) {
		count = value;
		System.out.println(count);
		if (count % 10 == 0) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}