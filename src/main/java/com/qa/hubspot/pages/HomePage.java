package com.qa.hubspot.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.util.Constant;
import com.qa.util.ElementActions;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementactions;

	// 1. Object Repository
	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']//child::i18n-string");
	By accountName = By.xpath("//h5[@class='Heading-sc-9dtc71-0 H5-sc-1o270om-0 jaYosH']//span[2]");
	By accountMenu = By.xpath("//a[@id='account-menu']");
	By profileLink = By.xpath("//div[@class='user-info-preferences']");
	By contactsMainmenu = By.xpath("//div[@class='desktop-nav-left-container']//a[@id='nav-primary-contacts-branch']");
	By contactsSubmenu = By.xpath("//div[@class='desktop-nav-left-container']//a[@id='nav-secondary-contacts']");

	// 2. Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(this.driver);
	}

	// 3. Page Actions

	public String getTitle() {
		return elementactions.waitForPageTitle(Constant.HOME_PAGE_TITLE);
	}

	public boolean accountNamedisplayed() {
		return elementactions.isElementDisplayed(accountName);
	}

	public String getAccountName() {
		return elementactions.doGetText(accountName);
	}

	public void accountMenuExpand() {
		elementactions.doClick(accountMenu);
	}

	public ProfilePage goToProfilePage() {
		elementactions.doClick(accountMenu);
		elementactions.doClick(profileLink);
		return new ProfilePage(driver);
	}

	public ContactsPage goToContactsPage() {
		elementactions.doClick(contactsMainmenu);
		elementactions.doClick(contactsSubmenu);
		return new ContactsPage(driver);
	}

}
