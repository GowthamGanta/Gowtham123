package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		int userId = 6;

		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		// 1. Load the input

		user.setFirstName("Nithin");
		user.setMiddleName("Kumar");
		user.setLastName("K");

		user.setEmail("xyz123@gmail.com");
		user.setMobile("123645978");

		Address address = user.getAddress();
		address.setLineOne("LP1");
		address.setLineTwo("Temple1");
		address.setCity("NDG");
		address.setState("AP");
		address.setPincode("52180");
		address.setCountry("INDIA");

		// 2. Call the Service

		boolean isUserUpdate = ferservice.updateUser(user);

		// 3. Print the Status
		
		if (isUserUpdate) {
			System.out.println("User profile updated successfully.......");
		} else {
			System.out.println("User profile update is failed.........");
		}
	}

}
