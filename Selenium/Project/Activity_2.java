package JobBoarding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_2 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait ;
	
	@Test
	public void verifyWebheading() throws Exception {
		
		driver.get("https://alchemy.hguy.co/jobs/");
		String header= driver.findElement(By.className("entry-title")).getText();
		System.out.println("Header of the page: "+ header);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Assert.assertEquals(header, "Welcome to Alchemy Jobs");
		driver.close();
	}
	
}
