/*
 * Program runs through the string and checks for any non alphabetic character
 * If present, Custom Exception will be thrown
 */
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class AlphabeticCharacter {
	public AlphabeticCharacter() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Scanner scan = new Scanner(System.in);
		es.execute(() -> {
			while(true) {
				try {
					System.out.println("Enter an alphabet...");
					char msg = scan.next().charAt(0);
					AlphabetCheck.isAlpha(msg);
				} catch (NonAlphabeticException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		es.shutdown();
	}

	public static void main(String[] args) {
		new AlphabeticCharacter();
	}

}

// Custom Exception 
class NonAlphabeticException extends Exception{
	public NonAlphabeticException(String msg) {
		super(msg);
	}
}

// Checks for passed character is alphabet or not
class AlphabetCheck {
	static void isAlpha(char letter) throws NonAlphabeticException {
		
		if(!Character.isAlphabetic(letter)) {
			throw new NonAlphabeticException(letter + " is not an alphabet");
		}
		else {
			System.out.println(letter + " is an alphabet");
		}
	}
}