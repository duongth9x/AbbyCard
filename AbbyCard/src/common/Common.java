package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Common {
	public static WebDriver driver;
	public static final String URL="http://beta.abbycard.com/";
	public static final int TIMEOUTS=30;    
	public static final String URLChormedriver="E:\\TestNG1\\chromedriver.exe";
	public static final String URLCoccocDir="C:\\Users\\Computer\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe";
	public static final String URLIEdriver="E:\\TestNG1\\IEDriverServer32.exe";
	
	public static void TakeScreenshot() throws IOException
	{
		
		File scrSt = ((TakesScreenshot) driver).getScreenshotAs(OutputType. FILE );
        FileUtils.copyFile(scrSt, new File( "D:\\Image_Abby\\screenshort.png" ));
	   /* try
	    {            
	        Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
	        ss.SaveAsFile(@"F:\\Screenshots\\SeleniumTestingScreenshot.jpg", System.Drawing.Imaging.ImageFormat.Jpeg);
	    }
	    catch (Exception e)
	    {
	        Console.WriteLine(e.Message);
	        throw;
	    }*/
	}
}
