import java.util.Scanner;

public class AverageOfMarks {

	/**
	 * @description Program finds average of 10 Students Marks
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
			} catch (NumberFormatException e) {
				System.out.println("Wrong Input");
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
