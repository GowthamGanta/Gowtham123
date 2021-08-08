package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		// 1. Load the input

		int id = 6;
		String currentPassword = "tella";
		String newPassword = "123456789";

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(id, currentPassword, newPassword);

		// 3. Print the status

		if (isResetPassword) {
			System.out.println("Password Reset Succesfully..........");
		} else {
			System.out.println("Password Reset failed...........");
		}

	}

}
