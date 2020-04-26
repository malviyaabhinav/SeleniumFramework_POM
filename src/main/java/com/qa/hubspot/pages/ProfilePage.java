package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.Constant;
import com.qa.util.ElementActions;

public class ProfilePage {
	WebDriver driver;
	ElementActions elementactions;

	// Object Repository

	By header = By.xpath("//h1//i18n-string");
	By profileName = By.xpath("//span[@data-test-id='name']");
	By language = By.xpath("(//span[@class='private-dropdown__item__label'])[1]");
	By dateFormat = By.xpath("(//span[@class='private-dropdown__item__label'])[2]");
	By phoneNumber = By.xpath("//div[@id='code']");

	// Constructor
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(this.driver);
	}

	// Page Actions

	public String getTitle() {
		return elementactions.waitForPageTitle(Constant.PROFILE_PAGE_TITLE);
	}

	public String getPageHeader() {
		return elementactions.doGetText(header);
	}

	public String getProfileName() {
		return elementactions.doGetText(profileName);
	}

	public String getLanguage() {
		return elementactions.doGetText(language);
	}

	public String getDateFormat() {
		return elementactions.doGetText(dateFormat);
	}

	public String getPhoneNumber() {
		return elementactions.getElement(phoneNumber).getAttribute("value");
	}

}
