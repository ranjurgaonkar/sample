package selenium_chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selenium_firefox {

	WebDriver driver;
	
	@BeforeTest
	public void configure()

	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();

	}
		
		
		
		
	 @Test
	  public void f() {
	 
	 driver.get("http://10.232.237.143:443/TestMeApp/");
	 
	 }
	 
	 @AfterTest
	 public void closeApp()
	 {
		 driver.close();
	 }
	
	
	
	
}
