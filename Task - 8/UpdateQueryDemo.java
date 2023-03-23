/*
 * Program update data inside table in database using executeUpdate method
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQueryDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/acedb", "root", "root1234");
			con.setAutoCommit(false);
			String updateQuery = "UPDATE employee SET designation=?";
			PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
			preparedStatement.setString(1, "ACE2023 Intern");
			int result = preparedStatement.executeUpdate();
			con.commit();
			System.out.println(result + " records updated");
			System.out.println("Record Updated");

			String selectQuery = "SELECT * FROM employee";
			Statement statement = con.createStatement();
			ResultSet data = statement.executeQuery(selectQuery);
			while (data.next()) {
				System.out.println(data.getString(1) + " : " + data.getString(2) + " : " + data.getInt(3));
			}
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
