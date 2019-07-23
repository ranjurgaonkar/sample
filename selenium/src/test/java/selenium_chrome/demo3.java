package selenium_chrome;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo3 {
	
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
 
	 driver.get("http://10.232.237.143:443/TestMeApp/");
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	 
	 
 	 driver.findElement( By.xpath("//input[@id='userName']")).sendKeys("Admin");
 	 driver.findElement( By.xpath("//input[@id='password']")).sendKeys("Password456");
 	 driver.findElement(By.xpath("//input[@type='submit' and @name='Login']")).click();
 	 
 	 //assert the page title as "Admin home"
 	 Assert.assertEquals(driver.getTitle(),"Admin Home");
 	 
 	String msg =driver.findElement(By.xpath("/html/body/header/div/b")).getText();
 	System.out.println(msg);
 	Assert.assertEquals(msg, "Hi, Admin    SignOut");
 	driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();
 	 driver.findElement( By.xpath("//input[@id='catgName']")).sendKeys("Holidays");
 	 driver.findElement( By.xpath("//input[@id='catgDesc']")).sendKeys("Bags");
 	 driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-lg btn-success btn-block']")).click();
 	 
 }
 
 @AfterTest
 public void closeApp()
 {
	 driver.close();
 }
 
}
