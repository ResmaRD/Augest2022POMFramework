package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;



public class BaseTest {
	
		public DriverFactory df;
		public WebDriver driver;
		public Properties prop;
		
		public LoginPage loginPage;
		public AccountsPage accPage;
		public ProductInfoPage ProductInfoPage;
		public RegisterPage regPage;
		public SoftAssert SoftAssert;
		
		
		@BeforeTest
		public void setup() {
			
			df = new DriverFactory();
			prop= df.init_prop();
			driver = df.init_driver(prop);		
			loginPage = new LoginPage(driver);
			SoftAssert=new SoftAssert();
			
		//	accPage = new AccountsPage(driver);
		}
		
		@AfterTest
		public void tearDown() {
			
			driver.quit();
		}

	}



