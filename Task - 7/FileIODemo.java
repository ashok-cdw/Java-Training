/*
 * 1) Deletes a File
 * 2) Rename a File
 * 3) Display the size of a file 
 */

import java.io.File;

public class FileIODemo {
	public static void main(String[] args) {
		new DeleteFile("temp1.txt");
		new RenameFile("temp2.txt", "tempio.txt");
		new DisplaySizeOfFile("temp3.txt");
	}
}

class DeleteFile {
	public DeleteFile(String fileName) {
		try {
			File file = new File(fileName);
			if (file.delete()) {
				System.out.println(file.getName() + " deleted");
			} else {
				System.out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class RenameFile {
	public RenameFile(String oldFileName, String newFileName) {
		try {
			File oldFile = new File(oldFileName);
			File newFile = new File(newFileName);
			if (oldFile.renameTo(newFile)) {
				System.out.println(oldFile.getName() + " is renamed to " + newFile.getName());
			} else {
				System.out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class DisplaySizeOfFile {
	public DisplaySizeOfFile(String fileName) {
		try {
			File file = new File(fileName);
			System.out.println("File Size : " + file.length() + " bytes ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}