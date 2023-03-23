/*
 * Program writes the date object into file and read the saved data and convert into date object
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class WriteDateObject {

	public static void main(String[] args) {
		DateDetails date = new DateDetails();
		System.out.println("Actual Date : " + date.someDate);
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("someDate.dat"));
			outputStream.writeObject(date);

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("someDate.dat"));
			DateDetails storedDate = (DateDetails) inputStream.readObject();
			System.out.println("Stored Date : " + storedDate.someDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class DateDetails implements Serializable {
	Date someDate;

	public DateDetails() {
		this.someDate = new Date();
	}
}