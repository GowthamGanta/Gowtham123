package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		// 1. Load the input

		Expense expense = new Expense();
		expense.setType("Cinema");
		expense.setDate("10-07-2021");
		expense.setPrice(150);
		expense.setNumberOfItems(5);
		expense.setTotal(750);
		expense.setBywhom("Me");
		expense.setUserId(6);

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isAddExpense = ferService.addExpense(expense);

		// 3. Print the status

		if (isAddExpense) {
			System.out.println("Expense added Succesfully..........");
		} else {
			System.out.println("Expense add is failed...........");
		}
		
		System.out.println("Expense added Succesfully..........");
	}

}
