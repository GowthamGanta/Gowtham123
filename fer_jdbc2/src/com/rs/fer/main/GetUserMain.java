package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		// 1. Load the input

		int userId = 7;

		// 2. Call the service for business logic execution

		FERService ferService = new FERServiceImpl();
		User user = ferService.getUser(userId);

		// 3. Print the status

		if (user == null) {
			System.out.println("User is not Found");
		} else {
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Middle Name: " + user.getMiddleName());
			System.out.println("First Name: " + user.getLastName());

			System.out.println("........................");

			System.out.println("Email: " + user.getEmail());
			System.out.println("Mobile: " + user.getMobile());

			System.out.println(".........................");

			Address address = user.getAddress();

			System.out.println("Line 1: " + address.getLineOne());
			System.out.println("Line 2: " + address.getLineTwo());
			System.out.println("City: " + address.getCity());
			System.out.println("State: " + address.getState());
			System.out.println("Pincode: " + address.getPincode());
			System.out.println("Country: " + address.getCountry());

			System.out.println("........................");
		}
	}

}
