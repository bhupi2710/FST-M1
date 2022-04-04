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

public class Activity_8 {

	
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 5000) ;
	
	@Test
	public void loginWbsiteBackend() throws Exception {
		
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		WebElement username= driver.findElement(By.id("user_login"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String name= driver.findElement(By.className("display-name")).getText();
		System.out.println("Login name for the Website: "+ name);
		Assert.assertEquals(name, "root");
		driver.close();
	}
}
