package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class AddExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "INSERT INTO EXPENSE (expensetype, date, price, numberofitems , total, bywhom, userid) VALUES (?, ?, ?, ?, ?, ?, ?)";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "TV");
			preparedstatement.setString(2, "25-07-2021");
			preparedstatement.setFloat(3, 20000);
			preparedstatement.setInt(4, 1);
			preparedstatement.setFloat(5, 20000);
			preparedstatement.setString(6, "Me");
			preparedstatement.setInt(7, 6);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected > 0) {
				System.out.println("Expense added Succesfully..........");
			} else {
				System.out.println("Expense add is failed...........");
			}
		
		
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
	}
}
