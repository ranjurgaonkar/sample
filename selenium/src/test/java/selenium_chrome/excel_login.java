package selenium_chrome;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excel_login {

WebDriver driver;
	@BeforeTest
	public void configurebrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("http://10.232.237.143:443/TestMeApp/");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}  	
	
	
	@Test(dataProvider="credentials")
		public void login(String username,String password) {
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement( By.id("userName")).sendKeys("Lalitha");
		  driver.findElement(By.id("password")).sendKeys("password123");
		  driver.findElement(By.name("Login")).click();
		  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	  
	  
  }
	
	@DataProvider(name="credentials")
	public Object[][] getData() throws IOException
	{
		return excel2_read_col_row.readdata();
	}

	  @AfterTest
	  public void closeApp()
	  {
	 	 driver.close();
	  }
	  
}
