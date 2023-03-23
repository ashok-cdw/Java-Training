/*
 * Program copies content from one file and writes data into another file 
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileContents {

	public static void main(String[] args) {
		try {
			FileInputStream data = new FileInputStream("temp3.txt");
			FileOutputStream copiedData = new FileOutputStream("copiedData.txt");
			int character;
			while ((character = data.read()) != -1) {
				copiedData.write(character);
			}
			System.out.println("Data Copied");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}