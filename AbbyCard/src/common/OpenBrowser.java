package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class OpenBrowser {
	
	public static void multi_browser(String browser) throws Exception{
		//Firefox
		if (browser.equalsIgnoreCase("firefox")) {
			Common.driver = new FirefoxDriver();
			Common.driver.manage().window().maximize();
		//Chrome	
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Common.URLChormedriver);
			Common.driver = new ChromeDriver();	
			Common.driver.manage().window().maximize();
		//CocCoc	
		} else if (browser.equalsIgnoreCase("coccoc")) {
			System.setProperty("webdriver.chrome.driver", Common.URLChormedriver);			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setBinary(Common.URLCoccocDir);
			Common.driver = new ChromeDriver(options);					
		//IE	
		} else if (browser.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.ie.driver", Common.URLIEdriver);			  
			  
			  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			  caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			  caps.setCapability("nativeEvents",false);
			  Common.driver = new InternetExplorerDriver(caps);			  			  
			  Common.driver.manage().window().maximize();
		//Other	
		} else {
			throw new IllegalArgumentException("The Browser Type is undefined");
		}		
		Common.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);				
	}	
}