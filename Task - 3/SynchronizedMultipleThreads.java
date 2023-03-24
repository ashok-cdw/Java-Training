
/*
 * Three threads are created and print method is called in three threads 
 * with class synchronized
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMultipleThreads {
	static char[] msg = { '[', '-', '-', '-', '-', '-', '-', '-', 'M', 'e', 's', 's', 'a', 'g', 'e', '-', '-', '-', '-',
			'-', '-', '-', '-', '-', ']' };

	public SynchronizedMultipleThreads() {
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.execute(() -> {
			synchronized (MsgPrinter.class) {
				Thread.currentThread().setName("Thread 1");
				MsgPrinter.print(msg, 0, 7);
			}
		});

		es.execute(() -> {
			synchronized (MsgPrinter.class) {
				Thread.currentThread().setName("Thread 2");
				MsgPrinter.print(msg, 8, 14);
			}
		});

		es.execute(() -> {
			synchronized (MsgPrinter.class) {
				Thread.currentThread().setName("Thread 3");
				MsgPrinter.print(msg, 15, 24);
			}
		});
		es.shutdown();
	}

	public static void main(String[] args) {
		new SynchronizedMultipleThreads();
	}
}

class MsgPrinter {
	static int i;

	synchronized public static void print(char[] msg, int start, int end) {
		for (i = start; i <= end; i++) {
			System.out.print(msg[i]);
		}
	}
}