/*
 * Program copies content from one file line by line and writes data into another file 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyLineByLine {

	public static void main(String[] args) {
		try {
			BufferedReader data = new BufferedReader(new FileReader("temp3.txt"));
			FileWriter copiedData = new FileWriter(new File("copiedData.txt"));
			String line;
			while ((line = data.readLine()) != null) {
				copiedData.write(line);
			}
			System.out.println("Data Copied");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}