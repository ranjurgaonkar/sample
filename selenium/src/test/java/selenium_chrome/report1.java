package selenium_chrome;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
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

public class report1 {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	
  @BeforeTest
  public void startReport() {
	  
	  String path =System.getProperty("user.dir")+"/extent-reports/report1.html";
	  htmlReporter = new ExtentHtmlReporter(path);
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
  }

@Test
public void passTest()
{
	logger=extent.createTest("passTest");//method name we have to write in createTest("methodname")
	//test code goes here
	Assert.assertTrue(true);
	logger.log(Status.PASS, MarkupHelper.createLabel("Testcase passed is passTest",ExtentColor.GREEN));
}

@Test
public void failTest()
{
	logger=extent.createTest("failTest");//method name we have to write in createTest("methodname")
	Assert.assertTrue(false);

}
@Test
public void skipTest()
{
	logger =extent.createTest("skipTest");
	throw  new SkipException("not ready for testing");
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
