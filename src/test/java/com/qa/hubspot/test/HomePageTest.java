package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.util.Constant;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
		
	@BeforeMethod
	public void setUp() {
		basepage =new BasePage();
		prop =basepage.propertiesRead();
		driver =basepage.driverInitialization();
		loginpage =new LoginPage(driver);
		homepage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateTitle() {
		String title=homepage.getTitle();
		Assert.assertEquals(title, Constant.HOME_PAGE_TITLE);
	}
	

	@Test(priority=2)
	public void validateAccountNameIsDisplayed() {
		Assert.assertTrue(homepage.accountNamedisplayed());
	}
	
	@Test(priority=1, dependsOnMethods="validateAccountNameIsDisplayed")
	public void validateAccountName() {
		String accountName=homepage.getAccountName();
		Assert.assertEquals(accountName, Constant.ACCOUNT_NAME);
	}
	
	@Test(priority=4)
	public void validateAccountMenuExpand() {
		homepage.accountMenuExpand();
	}
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
