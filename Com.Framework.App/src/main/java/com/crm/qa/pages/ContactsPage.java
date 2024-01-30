package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath ="//button[text()=\"Create\"]")      //click on create 
	WebElement createContactLink;
	
	@FindBy(xpath = "//input[@name=\"first_name\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name=\"last_name\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name=\"middle_name\"]")
	WebElement middleName;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[5]")
	WebElement companyName;
	
	@FindBy(xpath =  "//button[text()=\"Save\"]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//i[@class=\"trash icon\"]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[text()=\"Delete\"]")
	WebElement confirmDeleteButn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String ftName, String ltName, String mdName, String cmName) {
		createContactLink.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		middleName.sendKeys(mdName);
		companyName.sendKeys(cmName);
		saveBtn.click();
		deleteBtn.click();
		confirmDeleteButn.click();

	}
     
}
