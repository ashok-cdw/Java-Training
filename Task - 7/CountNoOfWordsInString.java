/*
 * Program gets input from the user and counts no. of words
 */
import java.util.Scanner;

public class CountNoOfWordsInString {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String msg;
			while (true) {
				System.out.println("Enter Some String : ");
				msg = scan.nextLine();
				System.out.println("Words Count : " + msg.split(" ").length);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
