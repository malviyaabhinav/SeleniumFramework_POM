package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage {

	WebDriver driver;

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

	// Constructor
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions

	public void clickOnCreateContact() {
		driver.findElement(createContactButton).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCreateContactHeaderTitle() {
		return driver.findElement(createContactPopUpHeader).getText();
	}

	public void addContact(String email, String firstname, String lastname, String jobtitle, String phonenumber) {
		clickOnCreateContact();
		driver.findElement(emailField).sendKeys(email);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(jobTitle).sendKeys(jobtitle);
		driver.findElement(phone).sendKeys(phonenumber);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(submitContactDetails)).click().build().perform();

	}

}
