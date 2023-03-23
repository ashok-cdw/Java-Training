/*
 * Program reads data from file and prints content
 */
import java.io.FileInputStream;

public class PrintFileContents {

	public static void main(String[] args) {
		try {
			FileInputStream data = new FileInputStream("temp3.txt");
			int character;
			while((character = data.read() )!= -1) {
				System.out.print((char)character);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
