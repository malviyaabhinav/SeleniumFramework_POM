package com.qa.hubspot.test;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.util.Constant;

public class LoginPageTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	
	
	@BeforeMethod
	public void setUp() {
		basepage =new BasePage();
		prop =basepage.propertiesRead();
		driver =basepage.driverInitialization();
		loginpage =new LoginPage(driver);		
	}
	
	@Test(priority=1)
	public void validateTitle() {
		String title=loginpage.getTitle();
		System.out.println("The page title is: "+title);
		Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void validateSignUpLinkDisplayed() {
		Assert.assertTrue(loginpage.signUpDisplayed());
	}
	
	
	@Test(priority=3)
	public void validateLogin() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
