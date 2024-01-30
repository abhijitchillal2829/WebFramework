package Action_Pkg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass_Pkg.BaseClass_Pkg;

public class Various_Actions extends BaseClass_Pkg {

	public static void scroll_Actions(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void Actions(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static boolean findelement(WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully find element");
			} else {
				System.out.println("Unable to locate element");
			}
		}
		return flag;
	}

	public static boolean isDisplayed(WebElement ele) {
		boolean flag = false;
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
		} else {
			System.out.println("Not displayed");
		}
		return flag;
	}

	public static boolean isSelected(WebElement ele) {
		boolean flag = false;
		flag = findelement(ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("Element is selected");
			} else {
				System.out.println("Element is not selected");
			}
		} else {
			System.out.println("Not selected");
		}
		return flag;
	}

	public static boolean isEnable(WebElement ele) {
		boolean flag = false;
		flag = findelement(ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("Element is enable");
			} else {
				System.out.println("Element is not enable");
			}
		} else {
			System.out.println("Not enable");
		}
		return flag;
	}

	public static boolean Type_Value(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Value is entered");
			} else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}

	public static boolean selectBySendKey(WebElement ele, String value) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Selected value from dropdown");
			} else {
				System.out.println("Not selected value from dropdown");
			}
		}
	}

	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Value selected by index");
			} else {
				System.out.println("Value not selected by index");
			}
		}
	}

	public static boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Value selected by value");
			} else {
				System.out.println("Value not selected by value");
			}
		}
	}

	public static boolean selectByVisibleText(WebElement element, String visibleText) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByVisibleText(visibleText);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Value selected by visibleText");
			} else {
				System.out.println("Value not selected by visibleText");
			}
		}
	}

	public static boolean ClickByjavascript(WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Click action is performed");
			} else {
				System.out.println("Click action is not performed");
			}
		}
	}

	public static void ImplicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void ExplicitWait(Duration timeunit, WebElement ele) {
		WebDriverWait expli = new WebDriverWait(driver, timeunit);
		expli.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
	}
}
