package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.util.Constant;
import com.qa.util.ElementActions;

public class LoginPage extends BasePage {

	// 1. Define Page Object Repository
	// 2. Define Constructor
	// 3. Define Page Actions

	WebDriver driver;
	ElementActions elementactions;

	// 1. Define Page Object Repository
	By email = By.id("username");
	By passwordfield = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By showPassword = By.xpath("//span[contains(text(),'Show Password')]");
	By forgotPassword = By.linkText("Forgot my password");
	By signInWithGoogle = By.xpath("//span[contains(text(),'Sign in with Google')]");
	By signInWithSSO = By.id("ssoBtn");

	// 2. Define Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(this.driver);
	}

	// 3. Define all Page Actions here

	public String getTitle() {
		return elementactions.waitForPageTitle(Constant.LOGIN_PAGE_TITLE);
	}

	public HomePage doLogin(String username, String password) {
		elementactions.doSendKeys(email, username);
		elementactions.doSendKeys(passwordfield, password);
		elementactions.doClick(loginButton);
		return new HomePage(driver);
	}

	public void forgotPassword() {
		elementactions.doClick(forgotPassword);
	}

	public void showPassword() {
		elementactions.doClick(showPassword);
	}

	public boolean signUpDisplayed() {
		return elementactions.isElementDisplayed(signUp);
	}

	public void signUp() {
		elementactions.doClick(signUp);
	}

}
