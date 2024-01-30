package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
    String sheetName = "Contacts";
	
    public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = new ContactsPage();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);   //complete data is availble in data
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void validateCreateNewContacts(String firstname, String lastname, String middlename, String companyname) {		
		homepage.clickOnContactLink();
		contactpage.createNewContact(firstname, lastname, middlename, companyname);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
}
