/*
 * Program describes the command pattern 
 * 
 * Command will receive objects to work on and execute the set of commands
 */
package behaviourpattern;

public class CommandPattern {

	public static void main(String[] args) {
		MobilePhone phone = new MobilePhone();
		Command harish = new CallHarishCommand(phone);
		harish.execute();
	}
}

abstract class Command {
	MobilePhone phone;

	abstract void execute();
}

class CallHarishCommand extends Command {
	public CallHarishCommand(MobilePhone phone) {
		this.phone = phone;
	}

	@Override
	void execute() {
		phone.unlock();
		phone.increaseVolume();
		phone.call("Harish");
	}

}

class MobilePhone {
	public void unlock() {
		System.out.println("Phone Unlocked");
	}

	public void lock() {
		System.out.println("Phone Locked");
	}

	public void increaseVolume() {
		System.out.println("Volume Increased");
	}

	public void decreaseVolume() {
		System.out.println("Volume Decreased");
	}

	public void call(String name) {
		System.out.println("Calling...." + name);
	}
}
