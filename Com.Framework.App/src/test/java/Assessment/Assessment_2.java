package Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assessment_2 {
	
	@Test
	public void blezDemo_2() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),\"destination of the week! The Beach!\")]")).click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://blazedemo.com/vacation.html");
		driver.navigate().back();
	}

}
