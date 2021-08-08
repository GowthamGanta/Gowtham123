package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		// 1. Load the input

		int id = 3;

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isDeleteExpense = ferService.deleteExpense(id);

		// 3. Print the status

		if (isDeleteExpense) {
			System.out.println("Expense deleted Succesfully..........");
		} else {
			System.out.println("Expense delete is failed...........");
		}
	}

}
