package com.tests.web;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dataproviders.LoginDataProvider;
import com.validators.Validators;
import com.web.pages.LoginPage;

@Listeners(com.tests.listeners.TestListener.class)
public class LoginPageTest extends BaseWebTest {

	LoginPage loginpage;

	public String LoginPageTitle = "Sign In - Trifacta Wrangler";
	public String HomePageTitle = "Home - Trifacta Wrangler";

	@Test(priority = 1, description = "Open Login Page")
	public void OpenLoginPageTest() {
		loginpage = new LoginPage(driver);
		loginpage.OpenLoginPage();
		String expectedTitle = loginpage.GetLoginPageTitle();
		Validators.ValidateStringsEqual(LoginPageTitle, expectedTitle);
	}

	@Test(dataProvider = "LoginDP", priority = 2, description = "Login", dataProviderClass = LoginDataProvider.class)
	public void CheckLoginDetails(String email, String password) {
		loginpage.EnterEmailId(email);
		loginpage.EnterPassword(password);
		loginpage.ClickLoginButton();
		String expectedTitle = loginpage.GetLoginPageTitle();
		System.out.println(expectedTitle);
		Validators.ValidateStringsEqual(HomePageTitle, expectedTitle);
	}
}
