package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class LoginMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT * FROM USER WHERE USERNAME =? and PASSWORD =?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "ranjith12");
			preparedstatement.setString(2, "happy3568");

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

			boolean isValidUser = false;
			while (resultSet.next()) {
				isValidUser = true;

			}

			if (isValidUser) {
				System.out.println("Welcome to the user: admin");
			} else {
				System.out.println("Incorrect username/password. Please try again....");
			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

	}
}