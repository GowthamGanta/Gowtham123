package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class ResetPasswordMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "UPDATE USER SET PASSWORD=? WHERE ID =? and PASSWORD =?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "tella");
			preparedstatement.setInt(2, 6);
			preparedstatement.setString(3, "gowtham");

			// 4.1 Execute The statement.

			// 4.2 Process the resultSet

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected > 0) {
				System.out.println("Password Reset Succesfully..........");
			} else {
				System.out.println("Password Reset failed...........");
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

	}
}