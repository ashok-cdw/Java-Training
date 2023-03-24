/*
 * Same thread cannot be started twice
 */
public class ThreadDemo {

	public static void main(String[] args) {
		try {
			Thread thread1 = new Thread();
			thread1.start();
			thread1.start();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
