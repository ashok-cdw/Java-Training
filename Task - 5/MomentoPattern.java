import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class PersonalDetails implements Serializable {
	String name;
	int age;
	String city;
	String college;
	public PersonalDetails(String name, int age, String city, String college) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.college = college;
	}
	@Override
	public String toString() {
		return "PersonalDetails [name=" + name + ", age=" + age + ", city=" + city + ", college=" + college + "]";
	}
	
}

public class MomentoPattern {

	public static void main(String[] args) throws Exception {
		PersonalDetails ashokPersonalDetails =  new PersonalDetails("Ashok", 20, "Erode", "KEC");
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("myuserdata.dat"));
		outputStream.writeObject(ashokPersonalDetails);
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("myuserdata.dat"));
		PersonalDetails copiedPersonalDetails = (PersonalDetails) inputStream.readObject();
		
		System.out.println(copiedPersonalDetails);
		outputStream.close();
		inputStream.close();
	}
}
