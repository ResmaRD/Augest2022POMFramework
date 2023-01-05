package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class LoginPageTest extends BaseTest{
	@Test(description = "check the login page title", priority = 1)
	public void loginPageTitleTest() {

		String actTitle = loginPage.getLoginPageTitle();

		System.out.println("Login page title is : " + actTitle);

		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(description = "check the login page url", priority = 2)
	public void loginPageURLTest() {

		String actUrl = loginPage.getLoginPageUrl();

		System.out.println("Login page url is : " + actUrl);

		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));

	}

	@Test(description = "check the forgot pwd link is displayed", priority = 3)
	public void forgotPwdLinkTest() {

		Assert.assertTrue(loginPage.isForgotPwdLinkExist());

	}

	@Test(description = "check the register link is displayed" , priority = 4)
	public void registerLinkTest() {

		Assert.assertTrue(loginPage.isRegisterLinkExist());

	}

	@Test(description = "check the login with username and password" ,priority = 5)
	public void loginTest() {

		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()).isLogoutLinkExist());


	}
	

}
