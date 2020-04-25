package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProfilePage;
import com.qa.util.Constant;

public class ProfilePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profilepage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.propertiesRead();
		driver = basepage.driverInitialization();
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		profilepage = homepage.goToProfilePage();
	}

	@Test(priority = 0)
	public void validateTitle() {
		String title = profilepage.getTitle();
		Assert.assertEquals(title, Constant.PROFILE_PAGE_TITLE);

	}

	@Test(priority = 1)
	public void validatePageHeader() {
		String header = profilepage.getPageHeader();
		Assert.assertEquals(header, prop.getProperty("header"));
	}

	@Test(priority = 2)
	public void validateProfileName() {
		String name = profilepage.getProfileName();
		Assert.assertEquals(name, prop.getProperty("profilename"));
	}

	@Test(priority = 3)
	public void validateLanguage() {
		String language = profilepage.getLanguage();
		Assert.assertEquals(language, prop.getProperty("language"));
	}

	@Test(priority = 4)
	public void validateTimeZone() {
		String timezone = profilepage.getDateFormat();
		Assert.assertEquals(timezone, prop.getProperty("dateformat"));
	}

	@Test(priority = 5)
	public void validatePhoneNumber() {
		String phonenumber = profilepage.getPhoneNumber();
		Assert.assertEquals(phonenumber, prop.getProperty("phonenumber"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
