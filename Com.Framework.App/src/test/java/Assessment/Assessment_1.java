package Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assessment_1 {

	@Test
	public void blezDemo() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!", "Invalid title");
		driver.quit();

	}

}
