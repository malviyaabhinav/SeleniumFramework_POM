package com.qa.hubspot.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;

	// 1. Object Repository
	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']//child::i18n-string");
	By accountName = By.xpath("//h5[@class='Heading-sc-9dtc71-0 H5-sc-1o270om-0 jaYosH']//span[2]");
	By accountMenu = By.xpath("//a[@id='account-menu']");
	By profileLink =By.xpath("//div[@class='user-info-preferences']");
	By contactsMainmenu =By.xpath("//div[@class='desktop-nav-left-container']//a[@id='nav-primary-contacts-branch']");
	By contactsSubmenu =By.xpath("//div[@class='desktop-nav-left-container']//a[@id='nav-secondary-contacts']");
	
	

	// 2. Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean accountNamedisplayed() {
		return driver.findElement(accountName).isDisplayed();
	}

	public String getAccountName() {
		return driver.findElement(accountName).getText();
	}

	public void accountMenuExpand() {
		driver.findElement(accountMenu).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ProfilePage goToProfilePage() {
		driver.findElement(accountMenu).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(profileLink).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ProfilePage(driver);
	}
	
	public ContactsPage goToContactsPage() {
		driver.findElement(contactsMainmenu).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(contactsSubmenu).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ContactsPage(driver);
	}

	

}
