/*
 * Program inserts data into table in database using executeUpdate method
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQueryDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/acedb", "root", "root1234");
			con.setAutoCommit(false);
			String insertQuery = "INSERT INTO employee VALUES(?,?,?)";
			PreparedStatement statement = con.prepareStatement(insertQuery);
			statement.setString(1, "Harish");
			statement.setString(2, "Associate Consultant");
			statement.setInt(3, 21);
			int result = statement.executeUpdate();
			con.commit();
			System.out.println(result + " records updated");
			System.out.println("Record Inserted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
					System.out.println("Transaction Rolled Back");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}