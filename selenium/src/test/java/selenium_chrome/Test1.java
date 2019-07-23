package selenium_chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
WebDriver driver;
@BeforeTest
public void configure()

{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	//driver=driver.choosedriver("chrome");
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
