import java.util.Scanner;

/*
 * Program divides two numbers 
 * If any of the input is not a number, it catches the error and prints division by zero / poor input data
 * If input is q / Q then it breaks the loop
 */

public class NumeratorDivisor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numeratorInput = null;
		double numerator = 0;
		double divisor = 0;
		double result = 0;
		while (true) {
			System.out.println("Numerator : ");
			numeratorInput = scan.next();
			try {
				numerator = Double.parseDouble(numeratorInput);
				System.out.println("Divisor : ");
				divisor = scan.nextDouble();
				result = numerator / divisor;
				System.out.println("Result : " + result);
			} catch (Exception e) {
				if (numeratorInput.charAt(0) == 'q' || numeratorInput.charAt(0) == 'Q') {
					System.out.println("Exited");
					break;
				} else {
					System.out.println("division by zero/poor input data");
				}
			}
		}
	}

}
