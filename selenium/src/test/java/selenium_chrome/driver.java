package selenium_chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driver {

	public static WebDriver choosedriver(String browserName) {
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
			
	    }
		else if(browserName.equals("explorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Training_B6E.00.13\\Downloads\\DRIVERS\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
	
		else return null;
	
	
}
}