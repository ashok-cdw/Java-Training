/*
 * Program gets input from the user and counts the length
 */
import java.util.Scanner;

public class CountNoOfCharacters {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String msg;
			while (true) {
				System.out.println("Enter Some String : ");
				msg = scan.nextLine();
				System.out.println("Length : " + msg.toCharArray().length);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
