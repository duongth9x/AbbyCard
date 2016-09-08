package test;

import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.*;
import pageobject.Merchant_object.Register_page;

public class Register_test_POI_Single {

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {

		OpenBrowser.multi_browser(browser);

		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS, TimeUnit.SECONDS);
	}

	@Test
	public static void Register_POI() throws Exception {

		// Get data from Excel
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("AbbyCard.xlsx", "Register");

		String Merchantname = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String Contactname = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		String Phone = ExcelCommon_POI.getCellData(1, 3, ExcelWSheet);
		String Email = ExcelCommon_POI.getCellData(1, 4, ExcelWSheet);
		String Password = ExcelCommon_POI.getCellData(1, 5, ExcelWSheet);
		String Repassword = ExcelCommon_POI.getCellData(1, 6, ExcelWSheet);

		// Go to the register page
		Common.driver.get(Common.URL + "register/");
		// Fill data register form
		Common.driver.findElement(Register_page.txtMerchantname).clear();
		Common.driver.findElement(Register_page.txtMerchantname).sendKeys(Merchantname);
		Common.driver.findElement(Register_page.txtContactname).clear();
		Common.driver.findElement(Register_page.txtContactname).sendKeys(Contactname);
		Common.driver.findElement(Register_page.txtPhone).clear();
		Common.driver.findElement(Register_page.txtPhone).sendKeys(Phone);
		Common.driver.findElement(Register_page.txtEmail).clear();
		Common.driver.findElement(Register_page.txtEmail).sendKeys(Email);
		Common.driver.findElement(Register_page.txtPassword).clear();
		Common.driver.findElement(Register_page.txtPassword).sendKeys(Password);
		Common.driver.findElement(Register_page.txtRepassword).clear();
		Common.driver.findElement(Register_page.txtRepassword).sendKeys(Repassword);
		Thread.sleep(3000);
		Common.driver.findElement(Register_page.btnRegister).click();
		Thread.sleep(3000);
		// Verify
		try {
			String ActualMessage = Common.driver.findElement(Register_page.actualMess).getText();
			String ExpectMessage = "Login AbbyCard";
			assertEquals(ActualMessage, ExpectMessage);
			ExcelCommon_POI.writeDataToExcel(1, 7, "AbbyCard.xlsx", "Register", "Passed");
			System.out.println("Pass");
		} catch (Exception e) {
			ExcelCommon_POI.writeDataToExcel(1, 7, "AbbyCard.xlsx", "Register", "Failed");
			System.out.println("Fail");
		}
		// Take a screenshot of this page.
		Common.TakeScreenshot();
		/*
		 * File scrSt = ((TakesScreenshot)
		 * Common.driver).getScreenshotAs(OutputType.FILE); FileUtils.sa(scrSt,
		 * new File("D:\\Image_Abby\\account22.jpg"));
		 */
	}

	private static void assertEquals(String actualMessage, String expectMessage) {
		// TODO Auto-generated method stub

	}

	@AfterTest
	public void tearDown() throws Exception {
		Common.driver.quit();
	}
}
