package com.rs.fer.service.impl;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;

import junit.framework.TestCase;

public class FERServiceImplTest extends TestCase {

	FERService ferService = new FERServiceImpl();

	public void testLogin() {

		String username = "ranjith12";
		String password = "happy3568";

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.login(username, password);

		assertEquals(expected, actual);
	}

	public void testLoginInvalidUsername() {

		String username = "ranjith866";
		String password = "happy3568";

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.login(username, password);

		assertEquals(expected, actual);
	}

	public void testLoginInvalidPassword() {

		String username = "ranjith866";
		String password = "happy1234";

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.login(username, password);

		assertEquals(expected, actual);
	}

	public void testLoginBothInvalid() {

		String username = "ranjith2345";
		String password = "happy987456";

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.login(username, password);

		assertEquals(expected, actual);
	}

	public void testRegistration() {

		User user = new User();
		user.setFirstName("Ranjith");
		user.setMiddleName("Kumar");
		user.setLastName("Tella");
		user.setEmail("123@gmailcom");
		user.setUsername("ranjith12");
		user.setPassword("happy3568");
		user.setMobile("9501234567");

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.registration(user);

		assertEquals(expected, actual);
	}

	public void testRegistrationFailue() {

		User user = new User();
		// user.setFirstName("Ranjith");
		user.setMiddleName("Kumar");
		user.setLastName("Tella");
		user.setEmail("123@gmailcom");
		user.setUsername("ranjith12");
		user.setPassword("happy3568");
		user.setMobile("9501234567");

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.registration(user);

		assertEquals(expected, actual);
	}

	public void testAddExpense() {

		Expense expense = new Expense();
		expense.setType("Cinema");
		expense.setDate("10-07-2021");
		expense.setPrice(150);
		expense.setNumberOfItems(5);
		expense.setTotal(750);
		expense.setBywhom("Me");
		expense.setUserId(6);

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.addExpense(expense);

		assertEquals(expected, actual);
	}

	public void testAddExpenseFailed() {

		Expense expense = new Expense();
		expense.setType("Cinema");
		expense.setDate("10-07-2021");
		expense.setPrice(150);
		expense.setNumberOfItems(5);
		expense.setTotal(750);
		expense.setBywhom(null);
		expense.setUserId(6);

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.addExpense(expense);

		assertEquals(expected, actual);
	}

	public void testEditExpense() {

		Expense expense = new Expense();
		expense.setType("Mobile");
		expense.setDate("29-08-2021");
		expense.setPrice(5000);
		expense.setNumberOfItems(5);
		expense.setTotal(25000);
		expense.setBywhom("Me");
		expense.setId(6);

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.editExpense(expense);

		assertEquals(expected, actual);
	}

	public void testEditExpenseFailure() {

		Expense expense = new Expense();
		expense.setType("TV");
		expense.setDate("29-08-2021");
		expense.setPrice(5000);
		expense.setNumberOfItems(5);
		expense.setTotal(25000);
		expense.setBywhom("Me");
		expense.setId(8);

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.editExpense(expense);

		assertEquals(expected, actual);
	}

	public void testDeleteExpense() {

		int id = 19;

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.deleteExpense(id);

		assertEquals(expected, actual);
	}

	public void testDeleteExpenseFailure() {

		int id = 12;

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.deleteExpense(id);

		assertEquals(expected, actual);
	}

	public void testResetPassword() {

		int id = 9;
		String currentPassword = "happy3568";
		String newPassword = "123456789";

		// 2. Call the service for business logic execution

		boolean expected = true;
		boolean actual = ferService.resetPassword(id, currentPassword, newPassword);

		assertEquals(expected, actual);
	}

	public void testResetPasswordFailure() {

		// 1. Load the input

		int id = 9;
		String currentPassword = "happy6868";
		String newPassword = "123456789";

		// 2. Call the service for business logic execution

		boolean expected = false;
		boolean actual = ferService.resetPassword(id, currentPassword, newPassword);

		assertEquals(expected, actual);
	}

	public void testGetExpense() {

		// 1. Load the input

		int expenseId = 6;

		// 2. Call the service for business logic execution

		Expense expense = ferService.getExpense(expenseId);

		assertNotNull(expense);

	}

	public void testGetExpenseFailure() {

		// 1. Load the input

		int expenseId = 10;

		// 2. Call the service for business logic execution

		Expense expense = ferService.getExpense(expenseId);

		assertNull(expense);

	}

	public void testGetExpenses() {

		// 1. Load the input

		int userId = 6;

		// 2. Call the service for business logic execution

		List<Expense> expenses = ferService.getExpenses(userId);

		assertEquals(false, expenses.isEmpty());
	}

	public void testGetExpensesFailure() {

		// 1. Load the input

		int userId = 10;

		// 2. Call the service for business logic execution

		List<Expense> expenses = ferService.getExpenses(userId);

		assertEquals(true, expenses.isEmpty());
	}

	public void testGetExpenseReport() {

		// 1. Load the input

		int userId = 6;
		String expenseType = "Cinema";
		String fromDate = "10-07-2021";
		String toDate = "12-07-2021";

		// 2. Call the service for business logic execution

		List<Expense> expenses = ferService.expenseReport(userId, expenseType, fromDate, toDate);

		assertEquals(false, expenses.isEmpty());
	}

	public void testGetExpenseReportFailure() {

		// 1. Load the input

		int userId = 10;
		String expenseType = "Cinema";
		String fromDate = "10-07-2021";
		String toDate = "12-07-2021";

		// 2. Call the service for business logic execution

		List<Expense> expenses = ferService.expenseReport(userId, expenseType, fromDate, toDate);

		assertEquals(true, expenses.isEmpty());
	}

	public void testGetUser() {

		// 1. Load the input

		int userId = 7;

		// 2. Call the service for business logic execution

		User user = ferService.getUser(userId);

		assertNotNull(user);
	}

	public void testGetUseFailure() {

		// 1. Load the input

		int userId = 15;

		// 2. Call the service for business logic execution

		User user = ferService.getUser(userId);

		assertNull(user);
	}

	public void testUpdateUser() {

		int userId = 6;

		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		// 2. Call the Service

		boolean expected = true;
		boolean actual = ferservice.updateUser(user);

		assertEquals(expected, actual);
	}

	public void testUpdateUserFailure() {

		int userId = 25;
		boolean actual=false;
		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		// 2. Call the Service

		boolean expected = false;
		if(user!=null)
		actual = ferservice.updateUser(user);

		assertEquals(expected, actual);
	}

}
