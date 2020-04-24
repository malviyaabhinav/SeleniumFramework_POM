package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{
	
	// 1. Define Page Object Repository
	// 2. Define Constructor
	// 3. Define Page Actions
	
	
	
	WebDriver driver;
	
	// 1. Define Page Object Repository
	By email = By.id("username");
	By passwordfield =By.id("password");
	By loginButton =By.id("loginBtn");
	By signUp =By.linkText("Sign up");
	By showPassword =By.xpath("//span[contains(text(),'Show Password')]");
	By forgotPassword =By.linkText("Forgot my password");
	By signInWithGoogle =By.xpath("//span[contains(text(),'Sign in with Google')]");
	By signInWithSSO =By.id("ssoBtn");
	
	// 2. Define Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// 3. Define all Page Actions here
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public HomePage doLogin(String username, String password) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(passwordfield).sendKeys(password);
		driver.findElement(loginButton).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
		
	}
	
	public void forgotPassword() {
		driver.findElement(forgotPassword).click();
	}
	
	public void showPassword() {
		driver.findElement(showPassword).click();
	}
	
	public boolean signUpDisplayed() {
		return driver.findElement(signUp).isDisplayed();
	}
	
	public void signUp() {
		driver.findElement(signUp).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
