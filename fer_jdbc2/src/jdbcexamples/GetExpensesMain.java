package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class GetExpensesMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object
			

			String inputSql = "SELECT * FROM EXPENSE WHERE USERID =? ";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, 6);

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

				
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
	}
}