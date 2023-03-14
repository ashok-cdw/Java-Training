class A {
	public A() {
		System.out.println("Class A");
	}
}

class B {
	public B() {
		System.out.println("Class B");
	}
}

class C extends A {
	B obj = new B();
}

public class Excercise2 {

	public static void main(String[] args) {
		new C();
	}

}
