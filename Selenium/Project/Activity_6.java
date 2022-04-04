package JobBoarding;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Activity_6 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait;

	@Test
	public void applyToAJob() throws Exception {

		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.id("menu-item-24")).click();
		Set<String> listOfWindow = (Set<String>) driver.getWindowHandles();
		Iterator<String> i = listOfWindow.iterator();
		if (i.hasNext()) {
			driver.switchTo().window(i.next());
		}
		String title = driver.getTitle();
		System.out.println("Title of the Website: " + title);
		driver.findElement(By.id("search_keywords")).sendKeys("Banking");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		List<WebElement> jobs= driver.findElements(By.xpath("//*[contains(@class, 'type-job_listing')]"));
		jobs.get(2).click();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@class, 'application_button button')]")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.className("job_application_email")).click();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.findElement(By.className("job_application_email")).sendKeys(Keys.ESCAPE);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.className("job_application_email")).sendKeys(Keys.chord(Keys.ALT, Keys.F4));
		driver.close();
	}
	
}
