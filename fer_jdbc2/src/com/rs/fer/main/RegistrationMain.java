package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		// 1. Load the input

		User user = new User();
		user.setFirstName("Ranjith");
		user.setMiddleName("Kumar");
		user.setLastName("Tella");
		user.setEmail("123@gmailcom");
		user.setUsername("ranjith12");
		user.setPassword("happy3568");
		user.setMobile("9501234567");

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		boolean isRegister = ferService.registration(user);

		// 3. Print the status

		if (isRegister) {
			System.out.println("User registration is successful");
		} else {
			System.out.println("User registration is failed");
		}
	}

}
