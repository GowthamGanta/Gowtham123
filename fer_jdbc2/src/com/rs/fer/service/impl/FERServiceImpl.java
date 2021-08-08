package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		boolean isRegister = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "INSERT INTO USER (firstname, middlename, lastname, email, username,password, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, user.getFirstName());
			preparedstatement.setString(2, user.getMiddleName());
			preparedstatement.setString(3, user.getLastName());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getUsername());
			preparedstatement.setString(6, user.getPassword());
			preparedstatement.setString(7, user.getMobile());

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			isRegister = numOfRecAffected > 0;

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isRegister;
	}

	@Override
	public boolean login(String username, String password) {
		boolean isValidUser = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT * FROM USER WHERE USERNAME =? and PASSWORD =?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

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

		return isValidUser;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean addExpense = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "INSERT INTO expense (expensetype, date, price, numberOfItems, total, byWhom,userId) VALUES (?, ?, ?, ?, ?, ?, ?)";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, expense.getType());
			preparedstatement.setString(2, expense.getDate());
			preparedstatement.setFloat(3, expense.getPrice());
			preparedstatement.setInt(4, expense.getNumberOfItems());
			preparedstatement.setFloat(5, expense.getTotal());
			preparedstatement.setString(6, expense.getBywhom());
			preparedstatement.setInt(7, expense.getUserId());

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			addExpense = numOfRecAffected > 0;

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return addExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {
		boolean editExpense = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "UPDATE EXPENSE SET expenseType=?, Date =?, Price = ?, NumberOfItems = ?, Total = ?, ByWhom = ?  WHERE Id=?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, expense.getType());
			preparedstatement.setString(2, expense.getDate());
			preparedstatement.setFloat(3, expense.getPrice());
			preparedstatement.setInt(4, expense.getNumberOfItems());
			preparedstatement.setFloat(5, expense.getTotal());
			preparedstatement.setString(6, expense.getBywhom());
			preparedstatement.setInt(7, expense.getId());

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			editExpense = numOfRecAffected > 0;

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return editExpense;
	}

	@Override
	public boolean deleteExpense(int id) {
		boolean isDeleteExpense = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "DELETE FROM EXPENSE WHERE id=?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, id);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			isDeleteExpense = numOfRecAffected > 0;

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isDeleteExpense;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isResetPassword = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "UPDATE USER SET PASSWORD=? WHERE ID =? and PASSWORD =?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, newPassword);
			preparedstatement.setInt(2, userId);
			preparedstatement.setString(3, currentPassword);

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			isResetPassword = numOfRecAffected > 0;

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isResetPassword;
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		List<Expense> expenses = new ArrayList<Expense>();

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT * FROM EXPENSE WHERE USERID =?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, userId);

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

			Expense expense = null;
			while (resultSet.next()) {
				// Get all the column data

				int id = resultSet.getInt(1);
				String expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String bywhom = resultSet.getString(7);
				int uId = resultSet.getInt(8);

				expense = new Expense();
				expense.setId(id);
				expense.setType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setBywhom(bywhom);
				expense.setUserId(userId);

				expenses.add(expense);

			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public Expense getExpense(int expenseId) {

		Expense expense = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT * FROM EXPENSE WHERE ID=?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, expenseId);

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
				String bywhom = resultSet.getString(7);
				int uId = resultSet.getInt(8);

				expense = new Expense();
				expense.setId(id);
				expense.setType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setBywhom(bywhom);
				expense.setUserId(expenseId);

			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return expense;
	}

	@Override
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {

		List<Expense> expenses = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT * FROM EXPENSE WHERE USERID =? and EXPENSETYPE =? AND DATE BETWEEN ? AND ? ";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, userId);
			preparedstatement.setString(2, expenseType);
			preparedstatement.setString(3, fromDate);
			preparedstatement.setString(4, toDate);

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

			while (resultSet.next()) {

				Expense expense = null;

				// Get all the column data

				int id = resultSet.getInt(1);
				// String expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int uid = resultSet.getInt(8);

				expense = new Expense();
				expense.setId(id);
				expense.setType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setBywhom(byWhom);
				expense.setUserId(uid);

				expenses.add(expense);

			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	}

	@Override
	public User getUser(int userId) {
		User user = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "SELECT U.*, A.* FROM USER U LEFT JOIN ADDRESS A ON U.ID=A.USERID WHERE U.ID=?";
			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setInt(1, userId);

			// 4.1 Execute The statement.

			ResultSet resultSet = preparedstatement.executeQuery();

			// 4.2 Process the resultSet

			while (resultSet.next()) {

				userId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String middleName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				String email = resultSet.getString(5);
				String username = resultSet.getString(6);
				String password = resultSet.getString(7);
				String mobile = resultSet.getString(8);

				user = new User();
				user.setId(userId);
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				user.setMobile(mobile);

				int addrId = resultSet.getInt(9);
				String lineOne = resultSet.getString(10);
				String lineTwo = resultSet.getString(11);
				String city = resultSet.getString(12);
				String state = resultSet.getString(13);
				String pincode = resultSet.getString(14);
				String country = resultSet.getString(15);
				int uId = resultSet.getInt(16);

				Address address = new Address();
				address.setId(addrId);
				address.setLineOne(lineOne);
				address.setLineTwo(lineTwo);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				address.setCountry(country);
				address.setUserId(uId);

				user.setAddress(address);

			}

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isUserUpdate = false;

		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			// 3.Create the statement object

			String inputSql = "UPDATE USER SET FIRSTNAME=?, MIDDLENAME=?, LASTNAME=?, EMAIL=?, USERNAME=?, MOBILE=? WHERE ID=?";

			preparedstatement = connection.prepareStatement(inputSql);
			preparedstatement.setString(1, user.getFirstName());
			preparedstatement.setString(2, user.getMiddleName());
			preparedstatement.setString(3, user.getLastName());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getUsername());
			preparedstatement.setString(6, user.getMobile());
			preparedstatement.setInt(7, user.getId());

			// 4.Execute The statement.

			int numOfRecAffected = preparedstatement.executeUpdate();

			if (numOfRecAffected <= 0) {
				System.out.println("User registration is failed");
			} else {
				Address address = user.getAddress();
				int addressId = address.getId();
				if (addressId == 0) {
					inputSql = "INSERT INTO ADDRESS (LINE1, LINE2, CITY, STATE, PINCODE, COUNTRY, USERID) VALUES (?, ?, ?, ?, ?, ?, ?)";
					preparedstatement = connection.prepareStatement(inputSql);
					preparedstatement.setString(1, address.getLineOne());
					preparedstatement.setString(2, address.getLineTwo());
					preparedstatement.setString(3, address.getCity());
					preparedstatement.setString(4, address.getState());
					preparedstatement.setString(5, address.getPincode());
					preparedstatement.setString(6, address.getCountry());
					preparedstatement.setInt(7, user.getId());

					// 4. Execute The statement

					numOfRecAffected = preparedstatement.executeUpdate();

					if (numOfRecAffected > 0) {
						System.out.println("Address Inserted Successfully...........");
					}

				} else {
					inputSql = "UPDATE ADDRESS SET LINE1=?, LINE2=?, CITY=?, STATE=?, PINCODE=?, COUNTRY=? WHERE ID=?";
					preparedstatement = connection.prepareStatement(inputSql);
					preparedstatement.setString(1, address.getLineOne());
					preparedstatement.setString(2, address.getLineTwo());
					preparedstatement.setString(3, address.getCity());
					preparedstatement.setString(4, address.getState());
					preparedstatement.setString(5, address.getPincode());
					preparedstatement.setString(6, address.getCountry());
					preparedstatement.setInt(7, addressId);

					// 4. Execute The statement

					numOfRecAffected = preparedstatement.executeUpdate();
					if (numOfRecAffected > 0) {
						System.out.println("Address Updated Successfully...........");
					}
				}
			}

			isUserUpdate = numOfRecAffected > 0;

		} catch (SQLException s) {
			s.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isUserUpdate;
	}
}