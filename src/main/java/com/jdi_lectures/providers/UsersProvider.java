package com.jdi_lectures.providers;

import org.testng.annotations.DataProvider;

public class UsersProvider {

	@DataProvider(name="users")
	public static Object[][] createUsers() {
		return new Object[][] {
				{"epam", "1234"}
		};
	}
	
}
