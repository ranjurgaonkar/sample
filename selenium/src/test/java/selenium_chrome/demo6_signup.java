package selenium_chrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class demo6_signup {
	
	
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
	  driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click(); 
	  driver.findElement( By.xpath("//input[@id='userName']")).sendKeys("Raksha2");
	  driver.findElement( By.xpath("//input[@id='firstName']")).sendKeys("Raksha");
	  driver.findElement( By.xpath("//input[@id='lastName']")).sendKeys("Gaonkar");
	  driver.findElement( By.xpath("//input[@id='password']")).sendKeys("Password456");
	  driver.findElement(By.xpath("//input[@type='password' and @name='confirmPassword']")).sendKeys("Password456");
	  //gender
	  driver.findElement(By.xpath("//input[@type='radio' and @value='Female']")).click();
	  driver.findElement( By.xpath("//input[@id='emailAddress']")).sendKeys("raksha@gmail.com");
	  driver.findElement( By.xpath("//input[@id='mobileNumber']")).sendKeys("9482020845");
	  
	  driver.findElement( By.xpath("//input[@id='dob']")).click();
	  //click on calender icon
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
	  //for year
	  
	  Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
	  year.selectByVisibleText("1998");
	  
	  //for month
	  Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
	  month.selectByVisibleText("May");
	  
	  //for date
	  driver.findElement(By.linkText("13")).click();
	  
	  
	  driver.findElement( By.xpath("//*[@id='address']")).sendKeys("Hosa herwatta ,Kumta");
	 
	  Select securityQuest = new Select(driver.findElement(By.id("securityQuestion")));
	  List<WebElement> options = securityQuest.getOptions();
	  options.get(1);
	  securityQuest.selectByIndex(1);
	  driver.findElement( By.xpath("//input[@id='answer']")).sendKeys("Blue");
	    
	  driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();
  
  
  }
  
  @AfterTest
  public void closeApp()
  {
 	 driver.close();
  }
  

}
