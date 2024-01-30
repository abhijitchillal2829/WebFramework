package TestClass_Pkg;



import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_Ama_CreateAccount {

	@Test
	public void Amazon() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		String Expected_url = driver.getCurrentUrl();
		Assert.assertEquals(Expected_url, "https://www.amazon.in/", "Url mismatched");
		WebElement ele = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));

		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();

		driver.findElement(By.xpath("//span[text()=\"Sign in\"]")).click();
		driver.findElement(By.id("createAccountSubmit")).click();

		driver.findElement(By.id("ap_customer_name")).sendKeys("Abhijit Chillal");
		driver.findElement(By.id("ap_phone_number")).sendKeys("8856805966");
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("abhijit.chillal@apmosys.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("abhijit@123");
		driver.findElement(By.id("continue")).click();

		// complete puzzle
		String Actual_Title_page = driver.getTitle();
		Assert.assertEquals(Actual_Title_page, "Authentication required", "Title mismatched");
		driver.quit();

	}
}
