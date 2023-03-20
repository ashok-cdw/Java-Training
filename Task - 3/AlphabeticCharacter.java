/*
 * Program runs through the string and checks for any non alphabetic character
 * If present, Custom Exception will be thrown
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class AlphabeticCharacter {
	char[] msg = "Ashok$Employee$Of$CDW$123^&".toLowerCase().toCharArray();

	public AlphabeticCharacter() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(() -> {
			for (int i = 0; i < msg.length; i++) {
				try {
					AlphabetCheck.isAlpha(msg[i]);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
		
		if(Character.isAlphabetic(letter)) {
			System.out.println(letter);
		}
		else {
			throw new NonAlphabeticException(letter + " is not an alphabet");
		}
	}
}