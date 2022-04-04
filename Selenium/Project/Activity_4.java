package JobBoarding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_4 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait ;
	
	@Test
	public void verifySecondheading() throws Exception {
		
		driver.get("https://alchemy.hguy.co/jobs/");
		String header= driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2")).getText();
		System.out.println("Header of the page: "+ header);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Assert.assertEquals(header, "Quia quis non");
		driver.close();
	}
	
	
}
