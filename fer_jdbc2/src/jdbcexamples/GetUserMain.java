package jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			// 1.Register the driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2. To Get the connection object

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");

			// 3.Create the statement object

			String inputSql = "SELECT U.*, A.* FROM USER U LEFT JOIN ADDRESS A ON U.ID=A.USERID WHERE U.ID=?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, 6);

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

			while (resultSet.next()) {

				String firstname = resultSet.getString(2);
				String middlename = resultSet.getString(3);
				String lastname = resultSet.getString(4);
				String email = resultSet.getString(5);
				String mobile = resultSet.getString(8);

				String line1 = resultSet.getString(10);
				String line2 = resultSet.getString(11);
				String city = resultSet.getString(12);
				String state = resultSet.getString(13);
				String pincode = resultSet.getString(14);
				String country = resultSet.getString(15);

				System.out.println("First Name: " + firstname);
				System.out.println("Middle Name: " + middlename);
				System.out.println("First Name: " + lastname);

				System.out.println("....................");

				System.out.println("Email: " + email);
				System.out.println("Mobile: " + mobile);

				System.out.println("....................");

				System.out.println("Line 1: " + line1);
				System.out.println("Line 2: " + line2);
				System.out.println("City: " + city);
				System.out.println("State: " + state);
				System.out.println("Pincode: " + pincode);
				System.out.println("Country: " + country);

			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			try {
				// 5. Close the connection object
				connection.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
	}
}