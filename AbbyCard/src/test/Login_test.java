package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.*;
import pageobject.Merchant_object.Login_page;
public class Login_test {
	Logger log = Logger.getLogger("devpinoyLogger");
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {

		OpenBrowser.multi_browser(browser);

		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS, TimeUnit.SECONDS);
	}
	
	@Test(priority = 0, enabled = true)
	public void Email_and_pass_null() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		log.debug("Get URL Successful");
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("");
		log.debug("Type email null");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("");
		Common.driver.findElement(Login_page.btnLogin).click();
		if(Common.driver.getPageSource().contains("Trường email không được bỏ trống."))
		{
		System.out.println("Email and pass null");
		}
		else
		{
		System.out.println("Email and pass not null");
		}
	}
	
	@Test(priority = 1, enabled = true)
	public void Email_invalid() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("duongth9xgmail.com");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("123456");
		Common.driver.findElement(Login_page.btnLogin).click();
		if(Common.driver.getPageSource().contains("Trường email phải là một địa chỉ email hợp lệ."))
		{
		System.out.println("Email invalid");
		}
		else
		{
		System.out.println("Fail");
		}
		
	}
	
	@Test(priority = 2, enabled = true)
	public void Pass_too_short() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("duongth9x@gmail.com");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("123");
		Common.driver.findElement(Login_page.btnLogin).click();
		if(Common.driver.getPageSource().contains("Trường mật khẩu phải có tối thiểu 6 ký tự."))
		{
		System.out.println("Pass is too short");
		}
		else
		{
		System.out.println("Fail");
		}
	}
	@Test(priority = 3, enabled = true)
	public void Pass_always_right() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("duongth9x@gmail.com");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("1=1");
		Common.driver.findElement(Login_page.btnLogin).click();	
	}
	
	@Test(priority = 4, enabled = true)
	public void Account_unauthenticated() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("");
		Common.driver.findElement(Login_page.btnLogin).click();
		if(Common.driver.getPageSource().contains("Tài khoản chưa được xác thực. Kiểm tra Email để kích hoạt tài khoản"))
		{
		System.out.println("Account unauthenticated");
		}
		else
		{
		System.out.println("Login fail");
		}
	}
		
			
	@Test(priority = 5, enabled = true)
	public void Login_successful() throws Exception {
		Common.driver.get(Common.URL +"login/");	
		Common.driver.findElement(Login_page.txtEmail_login).clear();
		Common.driver.findElement(Login_page.txtEmail_login).sendKeys("duongth9x@gmail.com");
		Common.driver.findElement(Login_page.txtPass_login).clear();
		Common.driver.findElement(Login_page.txtPass_login).sendKeys("123456");
		Common.driver.findElement(Login_page.btnLogin).click();
		
		if(Common.driver.getPageSource().contains("Welcome Administrator"))
		{
		System.out.println("Login successful");
		}
		else
		{
		System.out.println("Login fail");
		}
		Common.driver.findElement(Login_page.btnLogout).click();
		Common.driver.findElement(Login_page.btnConfirmlogout).click();
		if(Common.driver.getPageSource().contains("Đăng xuất tài khoản thành công"))
		{
		System.out.println("Logout successful");
		}
		else
		{
		System.out.println("Logout fail");
		}
	
	}
	@AfterTest
	public void tearDown() throws Exception {
		 Common.driver.quit();
	}
	
}
