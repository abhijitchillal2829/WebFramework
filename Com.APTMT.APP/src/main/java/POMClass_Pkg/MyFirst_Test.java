package POMClass_Pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Action_Pkg.Various_Actions;
import BaseClass_Pkg.BaseClass_Pkg;

public class MyFirst_Test extends BaseClass_Pkg{
	
	@FindBy(xpath = "//input[@placeholder=\"Email ID\"]")
	public WebElement UserMail;
	
	@FindBy(xpath = "//input[@name=\"loginPassword\"]")
	public WebElement Pass;
	
	public MyFirst_Test() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void User(String Text) {
		Various_Actions.Type_Value(UserMail, Text);
	}
	
	public void Pass1(String Pass_Text) {
		Various_Actions.Type_Value(Pass, Pass_Text);
	}

}
