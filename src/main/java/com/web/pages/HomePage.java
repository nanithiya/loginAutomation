package com.web.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@data-id='help']")
	WebElement helpIcon;

	@FindBy(xpath = "//*[@data-id='about']")
	WebElement aboutLink;

	@FindBy(xpath = "//*[@class='close tricon']")
	WebElement closePopUpButton;

	@FindBy(xpath = "//*[@data-id='settings']")
	WebElement userSettingsIcon;

	@FindBy(xpath = "//*[@data-id='sign-out']")
	WebElement signOutButton;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::h4")
	WebElement aboutPopupTitle;

	@FindBy(xpath = "//*[@class='modal fade']/descendant::h4[contains(text(), 'About')]/ancestor::div[@class = 'modal fade']")
	WebElement aboutPopup;

	@FindBy(xpath = "//div[contains(@class, 'sign-in-view')]")
	WebElement signInContainer;

	public void ClickHelpIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(helpIcon));
		helpIcon.click();
	}

	public void ClickAboutLink() {
		aboutLink.click();
	}

	public void CloseAboutPopUp() {
		wait.until(ExpectedConditions.elementToBeClickable(closePopUpButton));
		closePopUpButton.click();
	}

	public void ClickProfileIcon() {
		userSettingsIcon.click();
	}

	public void ClickSignOutButton() {
		signOutButton.click();
	}

	public String GetAboutPopUpTitle() {
		wait.until(ExpectedConditions.elementToBeClickable(aboutPopupTitle));
		return aboutPopupTitle.getText();
	}

	public Boolean isAboutLinkElementPresent() {
		return aboutLink != null;
	}

	public Boolean isAboutPopUpElementPresent() throws ElementNotVisibleException {
		wait.until(ExpectedConditions.elementToBeClickable(aboutPopup));
		if (aboutPopup.getAttribute("class").contentEquals("modal fade"))
			return false;
		else
			return true;
	}

	public Boolean isSignOutNavigatedToSignInPage() throws ElementNotVisibleException {
		wait.until(ExpectedConditions.elementToBeClickable(signInContainer));
		System.out.println(signInContainer.getAttribute("class"));
		if (signInContainer.getAttribute("class").contains("sign-in-view"))
			return true;
		else
			return false;
	}
}
