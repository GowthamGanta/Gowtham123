package jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UdateProfileMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			// 1.Register the driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2. To Get the connection object

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");

			// 3.Create the statement object

			String inputSql = "UPDATE USER SET FIRSTNAME=?, MIDDLENAME=?, LASTNAME=?, EMAIL=?, USERNAME=?, MOBILE=? WHERE ID=?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, "Ranjith1");
			preparedstatement.setString(2, "Kumar5");
			preparedstatement.setString(3, "Tella8");
			preparedstatement.setString(4, "12387@gmail.com");
			preparedstatement.setString(5, "ranjith72");
			preparedstatement.setString(6, "9501235478");
			preparedstatement.setInt(7, 6);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected <= 0) {
				System.out.println("User registration is failed");
			} else {

				int addressId = 11;
				if (addressId == 0) {
					inputSql = "INSERT INTO ADDRESS (LINE1, LINE2, CITY, STATE, PINCODE, COUNTRY, USERID) VALUES (?, ?, ?, ?, ?, ?, ?)";
					preparedstatement = connection.prepareStatement(inputSql);
					preparedstatement.setString(1, "BESIDE TEMPLE");
					preparedstatement.setString(2, "LP");
					preparedstatement.setString(3, "NDG");
					preparedstatement.setString(4, "521185");
					preparedstatement.setString(5, "AP");
					preparedstatement.setString(6, "IND");
					preparedstatement.setInt(7, 6);

					// 4. Execute The statement

					numOfRecAffected = preparedstatement.executeUpdate();

					if (numOfRecAffected > 0) {
						System.out.println("Address Inserted Successfully...........");
					}

				} else {
					inputSql = "UPDATE ADDRESS SET LINE1=?, LINE2=?, CITY=?, STATE=?, PINCODE=?, COUNTRY=? WHERE ID=?";
					preparedstatement = connection.prepareStatement(inputSql);
					preparedstatement.setString(1, "VAISHALI NAGAR");
					preparedstatement.setString(2, "MIYAPUR");
					preparedstatement.setString(3, "HYD");
					preparedstatement.setString(4, "500049");
					preparedstatement.setString(5, "TS");
					preparedstatement.setString(6, "IND");
					preparedstatement.setInt(7, 11);

					// 4. Execute The statement

					numOfRecAffected = preparedstatement.executeUpdate();
					if (numOfRecAffected > 0) {
						System.out.println("Address Updated Successfully...........");
					}
				}
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