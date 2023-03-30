/*
 * Program creates table in database using executeUpdate method
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateQueryDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/acedb", "root", "root1234");
			String createQuery = "CREATE TABLE student (studentname varchar(25),rollno varchar(25))";
			Statement statement = con.createStatement();
			int result = statement.executeUpdate(createQuery);
			System.out.println(result + " records updated");
			System.out.println("Table Created");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
