import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Project_Activity3 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "Android");
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	private void googleNoteWithReminder() throws Exception {

		// Wait for elements to load and click on it
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")"))).click();
		Thread.sleep(2000);
		// Locating Add Task Button Locator and send text
		String addNoteTitleLocator = "resourceId(\"com.google.android.keep:id/editable_title\")";
		driver.findElement(MobileBy.AndroidUIAutomator(addNoteTitleLocator)).sendKeys("New Note Title for Madhura");
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")"))
				.sendKeys("-----New Note for Madhura-----------");
		// wait and click the save button
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/menu_switch_to_list_view\")")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Tomorrow morning\")"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")"))).click();
		String reminderText= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/reminder_chip_text\")")).getText();
		System.out.println("Reminder Text for Note: "+reminderText);
		Assert.assertEquals(reminderText, "Tomorrow, 8:00 AM");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
