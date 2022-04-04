package JobBoarding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_9 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 5000);

	@Test
	public void createJobListingBackend() throws Exception {

		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		WebElement username = driver.findElement(By.id("user_login"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Job Listings")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.className("page-title-action")).click();
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@id, 'editor-')]")).sendKeys("classic");
		driver.findElement(By.id("_application")).clear();
		driver.findElement(By.id("_application")).sendKeys("http://www.testjobfrombackend.com");
		driver.findElement(By.id("_company_name")).sendKeys("IBM");
		driver.findElement(By.id("_company_twitter")).sendKeys("twitter@ibm.com");
		driver.findElement(By.id("_job_location")).sendKeys("Pune");
		driver.findElement(By.xpath("//button[contains(@class, 'editor-post-publish-button__button')]")).click();
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		String publish= driver.findElement(By.className("editor-post-publish-panel__header-published")).getText();
		Assert.assertEquals(publish, "Published");
		driver.close();
	}
}
