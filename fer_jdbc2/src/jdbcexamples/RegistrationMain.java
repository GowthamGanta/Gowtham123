package jdbcexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class RegistrationMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();
			
			// 3.Create the statement object

			String inputSql = "INSERT INTO USER (firstname, middlename, lastname, email, username,password, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "Ranjith");
			preparedstatement.setString(2, "Kumar");
			preparedstatement.setString(3, "Tella");
			preparedstatement.setString(4, "123@gmail.com");
			preparedstatement.setString(5, "ranjith12");
			preparedstatement.setString(6, "happy3568");
			preparedstatement.setString(7, "9501234567");

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected > 0) {
				System.out.println("User registration is successful");
			} else {
				System.out.println("User registration is failed");
			}

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
				DBUtil.closeConnection(connection);
		}
	}
}
