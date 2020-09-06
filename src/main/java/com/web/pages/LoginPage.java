package com.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {

	public static String appURL = "https://cloud.trifacta.com/";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@data-id='email']/div/input")
	WebElement emailTextbox;

	@FindBy(xpath = "//*[@data-id='password']/div/input")
	WebElement passwordTextbox;

	@FindBy(xpath = "//*[@data-id='primary-button']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@data-id='navigation']")
	WebElement navigationBar;

	public void OpenLoginPage() {
		driver.navigate().to(appURL);
		driver.manage().window().maximize();
	}

	public void EnterEmailId(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(emailTextbox));
		emailTextbox.clear();
		emailTextbox.click();
		emailTextbox.sendKeys(email);
	}

	public void EnterPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextbox));
		passwordTextbox.clear();
		passwordTextbox.click();
		passwordTextbox.sendKeys(password);
	}

	public void ClickLoginButton() {
		loginButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(navigationBar));
	}

	public String GetLoginPageTitle() {
		return driver.getTitle();
	}

	public String GetHomePageTitle() {
		return driver.getTitle();
	}

}
