package com.tests.web;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.validators.Validators;
import com.web.pages.HomePage;

@Listeners(com.tests.listeners.TestListener.class)
public class HomePageTest extends BaseWebTest {

	HomePage homepage;
	public String actualAboutPopUpTitle = "About Trifacta Wrangler";

	@Test(priority = 1, description = "Open Product help menu")
	public void OpenProductHelpMenu() {
		homepage = new HomePage(driver);
		homepage.ClickHelpIcon();
		Boolean result = homepage.isAboutLinkElementPresent();
		Validators.ValidateResultWithErrMessage(result, "Open Product help doesn't have about product option");
	}

	@Test(priority = 2, description = "Open product about PopUp")
	public void OpenAboutProductPopUp() {
		homepage.ClickAboutLink();
		String expectedPopupTitel = homepage.GetAboutPopUpTitle();
		Validators.ValidateStringsEqual(actualAboutPopUpTitle, expectedPopupTitel);
	}

	@Test(priority = 3, description = "Close product about PopUp")
	public void CloseAboutProductPopUp() {
		homepage.CloseAboutPopUp();
		Boolean result = homepage.isAboutPopUpElementPresent();
		Validators.ValidateFalseResultWithErrMessage(result, "Close Product about popup is not happening");
	}

	@Test(priority = 4, description = "Logout")
	public void LogoutApplication() {
		homepage.ClickProfileIcon();
		homepage.ClickSignOutButton();
		Boolean result = homepage.isSignOutNavigatedToSignInPage();
		Validators.ValidateResultWithErrMessage(result, "Logout page is not loading");
	}
}
