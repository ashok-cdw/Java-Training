/*
 * Program Throws Custom Exception When Age is Under 18
 */

// Custom Exception Class
class UnderAgeException extends Exception {

	public UnderAgeException(String errorMessage) {
		super(errorMessage);
	}
}

public class CustomException {

	public static void main(String[] args) {
		System.out.println("Welcome...");
		int age = 14;
		try {
			if (age < 18) {
				// Throwing Exception
				throw new UnderAgeException("You are under 18 ");
			} else {
				System.out.println("You are allowed");
			}
			// Catching Thrown Exception
		} catch (UnderAgeException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Thank You");
		}
	}
}
