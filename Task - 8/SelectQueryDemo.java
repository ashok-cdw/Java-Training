/*
 * Program queries data from table in database using executeQuery method
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQueryDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/acedb", "root", "root1234");
			String selectQuery = "SELECT * FROM employee";
			Statement statement = con.createStatement();
			ResultSet data = statement.executeQuery(selectQuery);
			while (data.next()) {
				System.out.println(data.getString(1) + " : " + data.getString(2) + " : " + data.getInt(3));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
