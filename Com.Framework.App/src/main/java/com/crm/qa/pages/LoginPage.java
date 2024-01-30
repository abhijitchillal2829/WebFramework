package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory
	
	@FindBy(name = "email")           
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class=\"login-with\"]")
	WebElement signupwithgoogle;
	
	//Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCrmImage() {
		return signupwithgoogle.isDisplayed();
	}
	
	public HomePage login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
