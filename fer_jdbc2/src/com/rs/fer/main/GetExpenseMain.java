package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		// 1. Load the input

		int expenseId = 4;

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(expenseId);

		// 3. Print the status

		if (expense == null) {
			System.out.println("Expense is not Found");
		} else {
			System.out.println("ID:" + expense.getId());
			System.out.println("Type: " + expense.getType());
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
