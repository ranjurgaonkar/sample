package selenium_chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginpage {
	
WebDriver driver;
@BeforeTest
public void configure()

{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
	//System.setProperty("webdriver.ie.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	
	driver=new ChromeDriver();
	
	driver.manage().window().maximize();

}
	
	
	
	
 @Test
  public void testLogin() {
 
	 driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	 driver.manage().window().maximize();
 	 driver.findElement( By.id("userName")).sendKeys("Lalitha");
 	 driver.findElement(By.id("password")).sendKeys("password123");
 	 driver.findElement(By.name("Login")).click();
 	 Assert.assertEquals(driver.getTitle(),"Home");
 	 driver.findElement(By.linkText("SignOut")).click();
 }
 
 @AfterTest
 public void closeApp()
 {
	 driver.close();
 }
 
	  
  }

