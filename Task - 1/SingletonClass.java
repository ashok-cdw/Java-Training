/*
 * getObject Method returns the instance for Singleton class
 * Only one instance is created here
 * No more instances will be created
 * Every thread will have access to the same Instance
 *
 */

class Singleton {
	private static Singleton singletonObject;

	private Singleton() {
		System.out.println("Singleton Class Object Created");
	}

	synchronized public static Singleton getObject() {
		if (singletonObject == null) {
			singletonObject = new Singleton();
		}
		return singletonObject;
	}

	public void HelloWorld() {
		System.out.println("Hello World");
	}
}

public class SingletonClass {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Singleton s = Singleton.getObject();
				s.HelloWorld();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				Singleton s = Singleton.getObject();
				s.HelloWorld();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				Singleton s = Singleton.getObject();
				s.HelloWorld();
			}
		}).start();
	}

}
