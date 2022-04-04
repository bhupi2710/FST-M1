package JobBoarding;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_5 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait;

	@Test
	public void navigateToJobs() throws Exception {

		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.id("menu-item-24")).click();
		Set<String> listOfWindow = (Set<String>) driver.getWindowHandles();
		Iterator<String> i = listOfWindow.iterator();
		if (i.hasNext()) {
			driver.switchTo().window(i.next());
		}
		String title = driver.getTitle();
		System.out.println("Title of the Website: " + title);
		Assert.assertEquals(title, "Jobs – Alchemy Jobs");
		driver.close();
	}

}
