package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		// 1. Load the input

		String username = "ranjith12";
		String password = "happy3568";

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isValidUser = ferService.login(username, password);

		// 3. Print the status

		if (isValidUser) {
			System.out.println("Welcome to the user: admin");
		} else {
			System.out.println("Incorrect username/password. Please try again....");
		}
	}

}
