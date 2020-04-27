package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.util.Constant;
import com.qa.util.ExcelUtil;

public class ContactsPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.propertiesRead();
		driver = basepage.driverInitialization();
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.goToContactsPage();

	}

	@Test(priority = 1)
	public void createContactPopUp() {
		contactspage.clickOnCreateContact();
		String header = contactspage.getCreateContactHeaderTitle();
		Assert.assertEquals(header, Constant.CREATE_CONTACT_POPUP_HEADER);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = ExcelUtil.getSheetData("Contacts");
		return data;
	}

	@Test(priority = 2, dataProvider = "getTestData")
	public void createContact(String email, String firstname, String lastname, String jobtitle, String phonenumber) {
		int temp =contactspage.addContact(email, firstname, lastname, jobtitle, phonenumber);
		if(temp==1) {
			Assert.fail("Contact Already Exists");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
