import java.util.Scanner;


/**
 * @description Negative Value Custom Exception
 *
 */
class NegativeValueError extends Exception {
	public NegativeValueError(String msg) {
		super(msg);
	}
}


/**
 * @description OutOfRange Custom Exception
 *
 */
class OutOfRangeError extends Exception {
	public OutOfRangeError(String msg) {
		super(msg);
	}
}

public class AverageOfMarksOwnException {

	/**
	 * @description Program finds average of 10 Students Marks, throws custom exception incase of invalid value
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] marksOfStudents = new int[10];
		int total = 0;
		double average = 0;
		for (int i = 0; i < marksOfStudents.length; i++) {
			System.out.println("Enter Marks of Student " + (i + 1) + " : ");
			try {
				marksOfStudents[i] = Integer.parseInt(scan.nextLine());
				if (marksOfStudents[i] < 0) {
					throw new NegativeValueError("Marks Cannot Be Negative");
				}
				if (!(marksOfStudents[i] >= 0 && marksOfStudents[i] <= 100)) {
					throw new OutOfRangeError("Marks Should in the Range of 0 to 100");
				}

			} catch (NumberFormatException error) {
				System.out.println("Wrong Input");
				i--;
			} catch (NegativeValueError error) {
				System.out.println(error.getMessage());
				i--;
			} catch (OutOfRangeError error) {
				System.out.println(error.getMessage());
				i--;
			}
		}

		for (int i = 0; i < marksOfStudents.length; i++) {
			total += marksOfStudents[i];
		}
		average = total / marksOfStudents.length;
		System.out.println("Average of Marks of Student : " + average);
	}
}
