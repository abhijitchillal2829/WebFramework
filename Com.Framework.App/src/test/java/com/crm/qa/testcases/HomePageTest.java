package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be seperated --independent with each other
	//before each test case ---launch the browser and login
	//@tset --excute test case
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title mismatched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactpage = homepage.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
