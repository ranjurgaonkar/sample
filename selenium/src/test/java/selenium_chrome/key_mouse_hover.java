package selenium_chrome;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class key_mouse_hover {
	
WebDriver driver;
	@BeforeTest
	public void configure()

	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	
	}

	
 @Test
  public void testkeyboardActions() throws InterruptedException {
 
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://10.232.237.143:443/TestMeApp/");
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebElement search=driver.findElement(By.id("myInput"));
	 search.sendKeys("b");
	 search.sendKeys("a");
	 search.sendKeys("g");
	 Thread.sleep(7000);
	 Actions act1 = new Actions(driver);
	 act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().build().perform();
	
	 driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	 String text=driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
	 Assert.assertTrue(text.contains("Hand bag"));	 
 }
  

 @AfterTest
 public void closeApp()
 {
	 driver.close();
 }
 
 
}
