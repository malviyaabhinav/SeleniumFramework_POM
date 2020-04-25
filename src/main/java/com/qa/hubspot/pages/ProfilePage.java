package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	WebDriver driver;

	// Object Repository

	By header = By.xpath("//h1//i18n-string");
	By profileName = By.xpath("//span[@data-test-id='name']");
	By language = By.xpath("(//span[@class='private-dropdown__item__label'])[1]");
	By dateFormat = By.xpath("(//span[@class='private-dropdown__item__label'])[2]");
	By phoneNumber = By.xpath("//div[@id='code']");

	// Constructor
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions

	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageHeader() {
		return driver.findElement(header).getText();
	}

	public String getProfileName() {
		return driver.findElement(profileName).getText();
	}

	public String getLanguage() {
		return driver.findElement(language).getText();
	}

	public String getDateFormat() {
		return driver.findElement(dateFormat).getText();
	}

	public String getPhoneNumber() {
		return driver.findElement(phoneNumber).getAttribute("value");
	}

}
