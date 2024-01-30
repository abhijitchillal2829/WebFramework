package BaseClass_Pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Action_Pkg.Various_Actions;

public class BaseClass_Pkg {

	public static Properties pro;
	public static WebDriver driver;
	public static Logger logger;

	@BeforeTest
	public void loadConfig() throws IOException {
	
		try {
			pro = new Properties();
			FileInputStream file = new FileInputStream("/home/apmosys/eclipse-workspace/Com.APTMT.APP/Configuration/Config.properties");
			pro.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	String browsername = pro.getProperty("browser");
	System.out.print(browsername);
	if (browsername.contains("chrome")) {
		System.out.print(browsername);
		driver = new ChromeDriver();
		System.out.print(browsername);
	} else if (browsername.contains("FireFox")) {
		driver = new FirefoxDriver();
	} else if (browsername.contains("IE")) {
		driver = new InternetExplorerDriver();
	}else
	{
		System.out.print("Invalid browser !!!");
		
	}
	System.out.print("Now launching browser -");
	Various_Actions.ImplicitWait(30);
	driver.get(pro.getProperty("url"));
	driver.manage().window().maximize();
	}
	
	public void ScreenShot(String Testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
//		String Timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
	//	String Name = "- Screenshot - ";
//		 dest = System.getProperty("/home/apmosys/eclipse-workspace/Com.APTMT.APP/ScreenShot");
//		String dest = System.getProperty("user.dir")+"/Screenshot/"+Testcasename+""+Name;
		File dest=new File("/home/apmosys/eclipse-workspace/Com.APTMT.APP/ScreenShot/mb.png");
		FileUtils.copyFile(Source, dest);
//		return dest;
	}
	
	@AfterTest
	public void End() {	
		driver.quit();
	}

}
