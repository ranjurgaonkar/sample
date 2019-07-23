package selenium_chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selenium_ie {

	
WebDriver driver;
	
	@BeforeTest
	public void configure()

	{
		
		System.setProperty("webdriver.ie.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		//driver=driver.choosedriver("ie");
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
