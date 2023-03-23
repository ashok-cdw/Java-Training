/*
 * Program prints the files and directories present in the path given in command line argument
 */
import java.io.File;
import java.util.Scanner;

public class ListFilesDirectories {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// /Users/ashok/eclipse-workspace/Exercise7/
			File directoryPath = new File(args[0]);
			String contents[] = directoryPath.list();
			System.out.println("List of files and directories in the specified directory:");
			for (int i = 0; i < contents.length; i++) {
				System.out.println(contents[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
