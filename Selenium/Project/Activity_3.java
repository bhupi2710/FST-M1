package JobBoarding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Activity_3 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait;

	@Test
	public void getUrlHeader() {

		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String url = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/div/img")).getAttribute("src");
		System.out.println("Url of the Image: " + url);
		driver.close();
	}

}
