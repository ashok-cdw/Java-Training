/*
 * Program created two threads to execute loadBullet and triggerGun
 * 
 * loadBullet statements will be executed and notifies 
 * At the same time triggerGun will be waiting for any notify
 * 
 * loadBullet will be waiting till the triggerGun is executed and notified	
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
	Gun gun = new Gun();
	public ProducerConsumer() {
		ExecutorService es = Executors.newFixedThreadPool(2);
		synchronized (gun) {
			es.execute(() -> {
				for(int i=0;i<5;i++) {
					gun.loadBullet();	
				}
			});
		}
		synchronized (gun) {
			es.execute(() -> {
				for(int i=0;i<5;i++) {
					gun.triggerGun();	
				}
			});
		}
	}

	public static void main(String[] args) {
		new ProducerConsumer();
	}
}

class Gun {
	boolean loaded;
	synchronized void loadBullet() {
		if(loaded) {
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Bullet Loaded");
		loaded = true;
		notify();
	}

	synchronized void triggerGun() {
		if(!loaded) {
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Gun Triggered\n");
		loaded = false;
		notify();
	}
}
