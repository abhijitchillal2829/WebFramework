package Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assessment_3 {

	@Test
	public void purchase_ticket() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement from = driver.findElement(By.xpath("//select[@name=\"fromPort\"]"));
		Select depar = new Select(from);
		depar.selectByVisibleText("Mexico City");

		WebElement to = driver.findElement(By.xpath("//select[@name=\"toPort\"]"));
		Select dest = new Select(to);
		dest.selectByVisibleText("London");

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		boolean lowest_value = driver
				.findElement(By.xpath("//input[@type=\"submit\"]/parent::td/following-sibling::td[text()=\"$200.98\"]"))
				.isDisplayed();

		if (lowest_value) {
			driver.findElement(By.xpath("(//input[@type=\"submit\"])[3]")).click();
		}

		driver.findElement(By.id("inputName")).sendKeys("Abhijit");
		driver.findElement(By.id("address")).sendKeys("Mumbai");
		driver.findElement(By.id("city")).sendKeys("Mumbai");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("zipCode")).sendKeys("12345");

		driver.findElement(By.id("creditCardNumber")).click();
		driver.findElement(By.id("creditCardNumber")).click();
		driver.findElement(By.id("nameOnCard")).sendKeys("Abhijit Chillal");

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

		driver.findElement(By.xpath("//h1[contains(text(),\"Thank you for your purchase today!\")]")).isDisplayed();
		driver.quit();

	}

}
