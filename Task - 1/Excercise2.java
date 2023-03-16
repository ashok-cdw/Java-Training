/*
 * Object for class C is created and super method is automatically called inside the default constructor of class C
 * So, It prints class A
 * Then, Object for class B is created and prints Class B 
 */
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
