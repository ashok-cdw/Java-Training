/*
 *	Interface called Stack is created and Implemented by FixedStack and DynamicStack Class
 *	Implemented Class overrides the methods
 *
 *	Fixed Stack has a array size of fixed size
 *	Dynamic Stack has a array size of fixed size, after reaching the limit it will double the size
 */

interface Stack {
	public void push(int number);
	public int pop();
}

class FixedStack implements Stack {
	int size;
	int peak = -1;
	int temp;
	int[] stack;

	public FixedStack(int size) {
		this.size = size;
		stack = new int[size];
	}

	@Override
	public void push(int number) {
		if (peak < size - 1) {
			stack[++peak] = number;
			System.out.println("Pushed : " + number);
		} else {
			System.out.println("Stack Overflow");
		}

	}

	@Override
	public int pop() {
		if (peak < 0) {
			System.out.println("Stack is Empty");
			temp = -1;
		} else {
			temp = stack[peak--];
		}
		return temp;
	}

}

class DynamicStack implements Stack {
	int size;
	int peak = -1;
	int temp;
	int[] stack;

	public DynamicStack(int size) {
		this.size = size;
		stack = new int[size];
	}

	@Override
	public void push(int number) {
		if (peak < size - 1) {
			stack[++peak] = number;
			System.out.println("Pushed : " + number);
		} else {
			size *= 2;
			int[] tempStack = new int[size];
			System.arraycopy(stack, 0, tempStack, 0, stack.length - 1);
			stack = tempStack;
			stack[++peak] = number;
			System.out.println("Pushed : " + number);
		}

	}

	@Override
	public int pop() {
		if (peak < 1) {
			System.out.println("Stack is Empty");
			temp = -1;
		} else {
			temp = stack[peak--];
		}
		return temp;
	}

}

public class StackImplementation {

	public static void main(String[] args) {
		FixedStack fs = new FixedStack(5);
		fs.push(10);
		fs.push(20);
		fs.push(30);
//		fs.push(40);
//		fs.push(50);
//		fs.push(60);
		System.out.println(fs.pop());
		System.out.println(fs.pop());

		DynamicStack ds = new DynamicStack(3);
		ds.push(100);
		ds.push(200);
		ds.push(300);
		ds.push(100);
		ds.push(200);
		ds.push(300);
		
		System.out.println(ds.pop());
		System.out.println(ds.pop());
	}

}
