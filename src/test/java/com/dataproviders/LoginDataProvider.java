package com.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name = "LoginDP")
	public static Object[][] LoginDP() {
		Object[][] data = { { "nanithiya@gmail.com", "Test.12345" } };
		return data;
	}
}
