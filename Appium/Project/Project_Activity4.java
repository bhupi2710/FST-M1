import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity4 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);

		driver.get("https://www.training-support.net/selenium");
	}

	@Test
	public void testingTodoList() throws Exception {

		// MobileElement pageTitle =
		// driver.findElementByXPath("//android.view.View[@text='Selenium']");
		// wait.until(ExpectedConditions.textToBePresentInElement(pageTitle,
		// "Selenium"));
		// wait & Scroll to To-Do List
		// wait.until(ExpectedConditions.elementToBeClickable(
		// MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).(\"To-DoList\")"))).click();
		try {
			driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
		} catch (InvalidSelectorException e) {
			// ignore
		}
		Thread.sleep(3000);
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View")
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")))
				.sendKeys("New task");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")")))
				.click();
		// MobileElement taskName =
		// driver.findElementByXPath("//android.view.View[@text='New task']");
		// wait.until(ExpectedConditions.textToBePresentInElement(taskName, "New
		// task"));
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Clear List\")")))
				.click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
