/*
 * Program throws custom exception when age is under 18 without catch block
 */

// Custom Exception Class
class UnderAgeException extends Exception {

	public UnderAgeException(String errorMessage) {
		super(errorMessage);
	}
}

public class CustomExceptionWithoutCatch {

	public static void main(String[] args) {
		System.out.println("Welcome...");
		int age = 14;
		try {
			if (age < 18) {
				// Throwing Exception without catch block
				throw new UnderAgeException("You are under 18 ");
			} else {
				System.out.println("You are allowed");
			}
		} finally {
			System.out.println("Thank You");
		}
	}
}
