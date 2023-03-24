
public class StringBufferLock extends Thread {
	StringBuffer buffer;

	public StringBufferLock(StringBuffer sb) {
		this.buffer = sb;
	}

	@Override
	public void run() {
		synchronized (buffer) {
			System.out.println(Thread.currentThread().getName());
			for (int i = 1; i <= 100; i++) {
				System.out.print(buffer);
			}
			buffer.setCharAt(0, (char) (buffer.charAt(0) + 1));
			System.out.println("\n\n");
		}
	}

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("A");
		StringBufferLock sbl1 = new StringBufferLock(buffer);
		sbl1.start();
		StringBufferLock sbl2 = new StringBufferLock(buffer);
		sbl2.start();
		StringBufferLock sbl3 = new StringBufferLock(buffer);
		sbl3.start();
	}

}
