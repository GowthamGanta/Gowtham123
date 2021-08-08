package jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseReportMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			// 1.Register the driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2. To Get the connection object

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");

			// 3.Create the statement object

			String inputSql = "SELECT * FROM EXPENSE WHERE USERID =? and EXPENSETYPE =? AND DATE BETWEEN ? AND ? ";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, 6);
			preparedstatement.setString(2, "Bike");
			preparedstatement.setString(3, "1-07-2021");
			preparedstatement.setString(4, "31-07-2021");

			// 4.1 Execute The statement.
				
			ResultSet resultSet = preparedstatement.executeQuery();
			
			// 4.2 Process the resultSet

			while (resultSet.next()) {
				// Get all the column data
				
				int id = resultSet.getInt(1);
				String expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int userId = resultSet.getInt(8);
				
				
				// Print them in the console view
				
				System.out.println("ID:"+id);
				System.out.println("expensetype: "+expenseType);
				System.out.println("Date: "+date);
				System.out.println("Price: "+price);
				System.out.println("Number of Items: "+numberOfItems);
				System.out.println("Total: "+total);
				System.out.println("By Whom: "+byWhom);
				System.out.println("UserId: "+userId);
				
				System.out.println("........................");
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