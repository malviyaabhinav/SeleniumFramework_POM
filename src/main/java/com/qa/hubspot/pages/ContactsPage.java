package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.BasePage;
import com.qa.util.ElementActions;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementActions elementactions;

	// Object Repository
	By createContactButton = By.xpath("//span[text()='Create contact']");
	By emailField = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By phone = By.xpath("//input[@data-field='phone']");
	By lifeCycleDropdown = By.xpath(
			"//label[text()='Lifecycle stage']//..//following-sibling::div[@class=\"private-form__input-wrapper\"]");
	By leadStatusDropdown = By
			.xpath("//label[text()='Lead status']//..//following-sibling::div[@class=\"private-form__input-wrapper\"]");
	By contactOwnerDropdown = By.xpath(
			"//label[text()='Contact owner']//..//following-sibling::div[@class=\"private-form__input-wrapper\"]");
	By submitContactDetails = By
			.xpath("//li[@class='uiListItem private-list__item p-bottom-1']//span[text()='Create contact']");
	By createContactPopUpHeader = By.xpath("//h3[text()='Create contact']");
	By contactAlreadyExistsMessage = By.xpath("//div[@class='text-center m-x-6']");
	By cancelButton = By.xpath("//button[@type='button']//span[text()='Cancel']");

	// Constructor
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(this.driver);
	}

	// Page Actions

	public void clickOnCreateContact() {
		elementactions.doClick(createContactButton);
	}

	public String getCreateContactHeaderTitle() {
		return elementactions.doGetText(createContactPopUpHeader);
	}

	public boolean checkContactExists() {
		return elementactions.isElementDisplayed(contactAlreadyExistsMessage);
	
	}

	public  int addContact(String email, String firstname, String lastname, String jobtitle, String phonenumber) {
		clickOnCreateContact();
		elementactions.doSendKeys(emailField, email);
		
		if(checkContactExists()) {
			return 1;
		}
		else {
		elementactions.doSendKeys(firstName, firstname);
		elementactions.doSendKeys(lastName, lastname);
		elementactions.doSendKeys(jobTitle, jobtitle);
		elementactions.doSendKeys(phone, phonenumber);
		elementactions.moveToElement(submitContactDetails);
		return 0;
		}
	}
}
















