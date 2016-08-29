package pageobject;

import org.openqa.selenium.By;

public class Merchant_object {
	
	public static class Register_page {
		// Register merchant
		public static By txtMerchantname = By.name("merchant_name");
		public static By txtContactname = By.name("contact_name");
		public static By txtPhone = By.name("phone_number");
		public static By txtEmail = By.name("email");
		public static By txtPassword = By.name("password");
		public static By txtRepassword = By.name("password_confirmation");
		public static By btnRegister = By.cssSelector(".btn.btn-primary.block.full-width.m-b");
		public static By actualMess;
	}

	public static class Login_page {
		// Login + logout merchant
		public static By txtEmail_login = By.name("email");
		public static By txtPass_login = By.name("password");
		public static By btnLogin = By.cssSelector(".btn.btn-primary.block.full-width.m-b");
		public static By btnLogout = By.cssSelector(".logout-confirm");
		public static By btnConfirmlogout = By.cssSelector(".swal2-confirm.styled");
	}
}