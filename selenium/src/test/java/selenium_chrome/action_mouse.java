package selenium_chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class action_mouse {
	
	
WebDriver driver;
	@BeforeTest
	public void configurebrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("http://10.232.237.143:443/TestMeApp/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}  	
  @Test
  public void testAboutus()
  {
	  Actions act1 =new Actions(driver);
	  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"))).
	  moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our\n" + 
	  		"												Offices')]"))).
	  moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"))).click().build().perform();
	  
  }
  
}
