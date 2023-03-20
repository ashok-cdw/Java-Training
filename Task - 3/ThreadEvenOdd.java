/*
 * Two threads are created
 * Even method and Odd method are called inside thread
 * Here, the methods are not synchronized
 * Output will be in random order
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadEvenOdd {
	public ThreadEvenOdd() {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			Printer.printEven(1, 100);
		});
		es.execute(() -> {
			Printer.printOdd(1, 100);
		});
		es.shutdown();

	}

	public static void main(String[] args) {
		new ThreadEvenOdd();
	}
}

class Printer {
	static void printEven(int start, int end) {
		System.out.println("Even Numbers : ");
		for (int i = start; i <= end; i++) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	static void printOdd(int start, int end) {
		System.out.println("Odd Numbers : ");
		for (int i = start; i < end; i++) {
			if (i % 2 != 0)
				System.out.print(i + " ");
		}
		System.out.println();
	}
}
