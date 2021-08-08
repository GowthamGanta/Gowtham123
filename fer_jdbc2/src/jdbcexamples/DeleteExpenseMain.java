package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "DELETE FROM EXPENSE WHERE id=?";

			preparedstatement = connection.prepareStatement(inputSql);

			preparedstatement.setInt(1, 2);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected > 0) {
				System.out.println("Expense Deleted Succesfully..........");
			} else {
				System.out.println("Expense Delete is failed...........");
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

	}
}
