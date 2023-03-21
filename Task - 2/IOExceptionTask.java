import java.io.FileReader;

/*
 * Program shows that it will cause IOException
 */

public class IOExceptionTask {

	public static void main(String[] args) {
		FileReader fr = new FileReader("abc.txt");
	}

}