package selenium_chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo4 {
	
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
  public void Login() {
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  String pagetitle = driver.getTitle();
	  System.out.println("Title of page="+pagetitle);
	  String pageurl = driver.getCurrentUrl();
	  System.out.println("Page Url="+pageurl);
	  driver.navigate().to("https://portal.accenture.com/");
	  String Ptitle = driver.getTitle();
	  System.out.println("Title of page="+Ptitle);
	  String PUrl = driver.getCurrentUrl();
	  System.out.println("Page Url="+PUrl);
	  
	  driver.navigate().back();
	  driver.navigate().forward();
	  driver.navigate().refresh();
	  
	  
	  
  }


  @AfterTest
  public void closeApp()
  {
 	 driver.close();
  }
  

}
