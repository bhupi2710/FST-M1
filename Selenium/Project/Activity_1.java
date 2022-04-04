package JobBoarding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_1 {
	WebDriver driver = new FirefoxDriver();
	

	@Test
	public void verifyWebTitle() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
		String title= driver.getTitle();
		System.out.println("Title of the Website: "+ title);
		Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
		driver.close();
	}

}
