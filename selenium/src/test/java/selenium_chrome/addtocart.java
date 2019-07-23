package selenium_chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addtocart {

WebDriver driver;
	@BeforeTest
	public void configurebrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("http://10.232.237.143:443/TestMeApp/");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}  	
  @Test
  public void testaddtocart()
  {
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.findElement( By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
	  
	  Actions act1 = new Actions(driver);
	  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'All\n" + 
	  		"										Categories')]"))).click().build().perform();
	  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().build().perform();
	  
	  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]"))).click().build().perform();
	  driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-shopping-cart']")).click();
	  
	  
	  
	  
	  
  }
}
