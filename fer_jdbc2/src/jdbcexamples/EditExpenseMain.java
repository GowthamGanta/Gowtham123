package jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			// 1.Register the driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2. To Get the connection object

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");

			// 3.Create the statement object

			String inputSql = "UPDATE EXPENSE SET expenseType=?, Date =?, Price = ?, NumberOfItems = ?, Total = ?, ByWhom = ?  WHERE Id=?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "Car");
			preparedstatement.setString(2, "15-07-2021");
			preparedstatement.setFloat(3, 100000);
			preparedstatement.setInt(4, 1);
			preparedstatement.setFloat(5, 100000);
			preparedstatement.setString(6, "By Me");
			preparedstatement.setInt(7, 2);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected > 0) {
				System.out.println("Expense edited Succesfully..........");
			} else {
				System.out.println("Expense edit is failed...........");
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