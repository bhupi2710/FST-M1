package JobBoarding;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Activity_7 {

	WebDriver driver = new FirefoxDriver();
	// WebDriverWait wait;

	@Test
	public void createNewJob() throws Exception {

		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.id("menu-item-26")).click();
		Set<String> listOfWindow = (Set<String>) driver.getWindowHandles();
		Iterator<String> i = listOfWindow.iterator();
		if (i.hasNext()) {
			driver.switchTo().window(i.next());
		}
		String title = driver.getTitle();
		System.out.println("Title of the Website: " + title);
		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(45)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("create_account_email"))));
		driver.findElement(By.id("create_account_email")).sendKeys("testuser2@test.com");
		driver.findElement(By.id("job_title")).sendKeys("Testing");
		driver.findElement(By.id("job_location")).sendKeys("Pune");
		WebElement dropdown = driver.findElement(By.id("job_type"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
		driver.findElement(By.id("tinymce")).sendKeys("This is the test job");
		driver.switchTo().defaultContent();
		// Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("application")).sendKeys("http://www.testjob.com");
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		driver.findElement(By.id("company_twitter")).sendKeys("twitter@ibm.com");
		driver.findElement(By.id("company_logo"))
				.sendKeys("C:\\Users\\MadhuraWagajkar\\Pictures\\Saved Pictures\\DPS Training Certificate.PNG");
		driver.findElement(By.name("submit_job")).click();
		Set<String> Windows = (Set<String>) driver.getWindowHandles();
		Iterator<String> w = Windows.iterator();
		if (w.hasNext()) {
			driver.switchTo().window(w.next());
		}
		driver.findElement(By.id("job_preview_submit_button"));
		// driver.close();
	}
}
