package selenium_chrome;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Viva {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	
	
	
	WebDriver driver;
	@BeforeTest
	public void configure()

	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver","C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();

		 driver.get("http://10.232.237.143:443/TestMeApp/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 String path =System.getProperty("user.dir")+"/extent-reports/report1.html";
		  htmlReporter = new ExtentHtmlReporter(path);
		  extent=new ExtentReports();
		  extent.attachReporter(htmlReporter);
		
	}

	@Test(priority=1)
     public void register() {
		  
		driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		
		  driver.findElement( By.xpath("//input[@id='userName']")).sendKeys("pppppp");
		  driver.findElement( By.xpath("//input[@id='firstName']")).sendKeys("Raksha");
		  driver.findElement( By.xpath("//input[@id='lastName']")).sendKeys("Gaonkar");
		  driver.findElement( By.xpath("//input[@id='password']")).sendKeys("password456");
		  driver.findElement(By.xpath("//input[@type='password' and @name='confirmPassword']")).sendKeys("password456");
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
	
	@Test(priority=1)
	public void login()
	{
	driver.findElement( By.id("userName")).sendKeys("lalitha");
	 driver.findElement(By.id("password")).sendKeys("password123");
	 driver.findElement(By.name("Login")).click();
	 Assert.assertEquals(driver.getTitle(),"Home");	
     }
	
	@Test(priority=3)
	public void addtocart()
	{	

		  Actions act1 = new Actions(driver);
		  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'All\n" + 
		  		"										Categories')]"))).click().build().perform();
		  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().build().perform();
		  
		  act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]"))).click().build().perform();
		  driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-shopping-cart']")).click();
		  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		  driver.findElement(By.id("btn")).click();
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  }

     
	

@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus() == ITestResult.FAILURE)
	{
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-testcase failed",ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-testcase failed", ExtentColor.RED));
		
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-testcase skipped",ExtentColor.RED));
	}
}

@AfterTest
public void endReport()
{
	extent.flush();
}

	
	
}
