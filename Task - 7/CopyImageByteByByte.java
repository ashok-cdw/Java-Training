/*
 * Program copies image byte by byte and writes into file 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyImageByteByByte {

	public static void main(String[] args) {
		try {
			FileInputStream originalImage = new FileInputStream(new File("original.png"));
			FileOutputStream copiedImage = new FileOutputStream(new File("copied.png"));
			byte[] buffer = new byte[1024];
			int length;
			while ((length = originalImage.read(buffer)) != -1) {
				copiedImage.write(buffer, 0, length);
			}
			originalImage.close();
			copiedImage.close();
			System.out.println("Image Copied");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
