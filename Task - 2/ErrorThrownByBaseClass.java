/*
 * @description - Derived class won't catches error thrown by base class unless it throws the exception
 */
class ErrorClass {
	public ErrorClass() throws Exception {
		System.out.println("Inside Base Class Constructor");
		throw new Exception("Error Occured");
	}
}

public class ErrorThrownByBaseClass extends ErrorClass {

	public ErrorThrownByBaseClass() throws Exception {
		System.out.println("Inside Derived Class Constructor");
	}

	public static void main(String[] args) {
		// new ErrorThrownByBaseClass();
	}

}
