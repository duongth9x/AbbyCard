package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.*;
import pageobject.Merchant_object.Register_page;

public class Register_test_POI {
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
		File scrSt = ((TakesScreenshot) Common.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrSt, new File("D:\\Image_Abby\\account22.jpg"));
	}

	private static void assertEquals(String actualMessage, String expectMessage) {
		// TODO Auto-generated method stub

	}

	@AfterTest
	public void tearDown() throws Exception {
		Common.driver.quit();
	}
}

// public class UserModel {
// public String Merchantname;
// public String Contactname;
// public String Phone;
// public String Email;
// public String Password;
// public String Repassword;
// }
//
// @BeforeTest
// @Parameters("browser")
//
// public void Register(String browser) throws Exception {
// OpenBrowser.multi_browser(browser);
// Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS,
// TimeUnit.SECONDS);
// }
//
// @Test(priority = 1, enabled = true)
// public void register() throws Exception {
//
// XSSFSheet ExcelWSheetRegister = ExcelCommon_POI.setExcelFile("AbbyCard.xlsx",
// "Register");
// int firstRow = ExcelWSheetRegister.getFirstRowNum();
// int lastRow = ExcelWSheetRegister.getLastRowNum();
//
// UserModel user;
// List<UserModel> listA = new ArrayList<UserModel>();
// for (int indexR = firstRow; indexR <= lastRow; indexR++) {
// user = new UserModel();
// // Fill data register form
// user.Merchantname = ExcelCommon_POI.getCellData(indexR, 1,
// ExcelWSheetRegister);
// user.Contactname = ExcelCommon_POI.getCellData(indexR, 2,
// ExcelWSheetRegister);
// user.Phone = ExcelCommon_POI.getCellData(indexR, 3, ExcelWSheetRegister);
// user.Email = ExcelCommon_POI.getCellData(indexR, 4, ExcelWSheetRegister);
// user.Password = ExcelCommon_POI.getCellData(indexR, 5, ExcelWSheetRegister);
// user.Repassword = ExcelCommon_POI.getCellData(indexR, 6,
// ExcelWSheetRegister);
// listA.add(user);
// }
//
// ExcelWSheetRegister = null;
//
// for (int index = 1; index < listA.size(); index++) {
// user = listA.get(index);
//
// Common.driver.get(Common.URL + "register/");
// Common.driver.findElement(Register_page.txtMerchantname).clear();
// Common.driver.findElement(Register_page.txtMerchantname).sendKeys(user.Merchantname);
// Common.driver.findElement(Register_page.txtContactname).clear();
// Common.driver.findElement(Register_page.txtContactname).sendKeys(user.Contactname);
// Common.driver.findElement(Register_page.txtPhone).clear();
// Common.driver.findElement(Register_page.txtPhone).sendKeys(user.Phone);
// Common.driver.findElement(Register_page.txtEmail).clear();
// Common.driver.findElement(Register_page.txtEmail).sendKeys(user.Email);
// Common.driver.findElement(Register_page.txtPassword).clear();
// Common.driver.findElement(Register_page.txtPassword).sendKeys(user.Password);
// Common.driver.findElement(Register_page.txtRepassword).clear();
// Common.driver.findElement(Register_page.txtRepassword).sendKeys(user.Repassword);
// Common.driver.findElement(Register_page.btnRegister).click();
// Thread.sleep(3000);
// // Take a screenshot of this page.
//// File scrSt = ((TakesScreenshot) Common.driver).getScreenshotAs(OutputType.
// FILE );
//// FileUtils. copyFile( scrSt, new File( "D:\\Image_Abby\\account1.jpg" ));
// try {
// // verify
// String ActualMessage =
// Common.driver.findElement(Register_page.actualMess).getText();
// String ExpectMessage = "Login AbbyCard";
// Assert.assertEquals(ActualMessage, ExpectMessage);
// ExcelCommon_POI.writeDataToExcel(index, 7, "AbbyCard.xlsx", "Register",
// "Passed");
// System.out.println("Pass");
// } catch (Exception e) {
// ExcelCommon_POI.writeDataToExcel(index, 7, "AbbyCard.xlsx", "Register",
// "Failed");
// System.out.println("Fail");
// }
// }
// }
//
// @AfterTest
// public void tearDown() throws Exception {
// Common.driver.quit();
// }
// }
