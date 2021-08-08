package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		// 1. Load the input

		int userId = 6;

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(userId);

		// 3. Print the status

		for (Expense expense : expenses) {
			System.out.println("ID:" + expense.getId());
			System.out.println("Expense Type: " + expense.getType());
			System.out.println("Date: " + expense.getDate());
			System.out.println("Price: " + expense.getPrice());
			System.out.println("Number of Items: " + expense.getNumberOfItems());
			System.out.println("Total: " + expense.getTotal());
			System.out.println("By Whom: " + expense.getBywhom());
			System.out.println("UserId: " + expense.getUserId());

			System.out.println("........................");
		}

	}

}
