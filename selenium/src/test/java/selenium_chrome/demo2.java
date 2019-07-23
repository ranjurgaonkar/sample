package selenium_chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo2 {

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
// 	 String actual=driver.getTitle();
 //	 System.out.println(actual);
 //	 String expected="Login";
 //	 Assert.assertEquals(actual, expected);
	 
 //	 System.out.println("found");
 	 
 	 List<WebElement> alllinks=driver.findElements(By.tagName("a"));
 	 
 	 System.out.println("count:"+alllinks.size());
 	 

 	for(int i=0;i<alllinks.size();i++)
 	{
 		System.out.println(alllinks.get(i).getAttribute("href"));
 	}
 	 
 	 
 	// Assert.assertEquals(driver.getTitle(),"Home");
 	// driver.findElement(By.linkText("SignOut"));
 }
 
 @AfterTest
 public void closeApp()
 {
	 driver.close();
 }
 
	  
  }
	
	
	
	

