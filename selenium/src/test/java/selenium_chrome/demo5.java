package selenium_chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class demo5 {
	
	
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
  public void Viewproduct() {
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//a[@href='login.htm']")).click(); 
	  driver.findElement( By.xpath("//input[@id='userName']")).sendKeys("Admin");
	  driver.findElement( By.xpath("//input[@id='password']")).sendKeys("Password456");
	  driver.findElement(By.xpath("//input[@type='submit' and @name='Login']")).click();
	  Assert.assertEquals(driver.getTitle(),"Admin Home");
	  
	  //absolute path
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[4]/button")).click();
	  Select catsel = new Select(driver.findElement(By.id("categorydropid")));

	  List<WebElement> options =catsel.getOptions();
	  	for(WebElement i :options)
	  	{
	  		if(i.getText().equals("Electronics"))
	  		{
	  			System.out.println(i.getText());
	  			Select subsel = new Select(driver.findElement(By.id("subcategorydropid")));
	  			List<WebElement> options1 =subsel.getOptions();
	  			for(WebElement j :options1)
	  		  	{
	  		  		if(j.getText().equals("Travel Kit"))
	  		  		{
	  		  			System.out.println(j.getText());
	  		         }
	  		
	  		
	            	}
	  
  
	  		}
	  	}
  }
  
  @AfterTest
  public void closeApp()
  {
 	 driver.close();
  }
  

}
