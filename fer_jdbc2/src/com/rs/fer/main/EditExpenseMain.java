package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		// 1. Load the input

		Expense expense = new Expense();
		expense.setType("Shopping");
		expense.setDate("12-06-2021");
		expense.setPrice(2500);
		expense.setNumberOfItems(4);
		expense.setTotal(10000);
		expense.setBywhom("Me");
		expense.setId(3);

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isEditExpense = ferService.editExpense(expense);

		// 3. Print the status

		if (isEditExpense) {
			System.out.println("Expense edited Succesfully..........");
		} else {
			System.out.println("Expense edit is failed...........");
		}
		
		System.out.println("Expense edited Succesfully..........");
		System.out.println("Expense edit is failed...........");
	}

}
