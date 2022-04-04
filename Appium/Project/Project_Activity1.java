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

public class Project_Activity1 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 API 28");
		caps.setCapability("platformName", "Android");
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void createGoogleTasks() throws Exception {
		googleTask("Complete Activity with Google Tasks");
		googleTask("Complete Activity with Google Keep");
		googleTask("Complete the second Activity Google Keep");
		Thread.sleep(2000);
		List <MobileElement> taskList = driver.findElementsByXPath("(//android.view.View[@content-desc=\"Mark as complete\"])");
		System.out.println("No of tasks added: "+taskList.size());
		Assert.assertEquals(taskList.size(),3);
	}

	private void googleTask(String task) throws Exception {

		// Wait for elements to load and click on it
		wait.until(ExpectedConditions
				.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Create new task\")"))).click();
		Thread.sleep(2000);
		// Locating Add Task Button Locator and send text
		String addTaskLocator = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";
		driver.findElement(MobileBy.AndroidUIAutomator(addTaskLocator)).sendKeys(task);
		// wait and click the save button
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")"))).click();
	}

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

}
