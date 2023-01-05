package com.qa.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;


public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By registerHeader = By.cssSelector("div#account-register h1");
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@value ='1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@value ='0']");
	private By privacy = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value ='Continue'] ");
	
	//Account succesfull message
	
	private By succesfullMsg = By.cssSelector("div#common-success h1");
	private By succesfullcontinueBtn = By.linkText("Continue");
	private By registerLink = By.linkText("Register");
	
	private By logout = By.linkText("Logout");
	
	
	public RegisterPage(WebDriver driver) {

		this.driver = driver;

		eleUtil = new ElementUtil(driver);
	}
	
	
	public boolean isRegisterAccountHeaderExist() {
		
		return eleUtil.WaitForElementVisible(registerHeader, Constants.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public boolean doAddPersonalDetails(String firstName, String lastName, String email , String telephone,String password, String confirmPassword) {
		
		
		eleUtil.WaitForElementVisible(this.firstName, Constants.DEFAULT_TIME_OUT).sendKeys(firstName);
		
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPassword, confirmPassword);
		
		eleUtil.doClick(privacy);
		eleUtil.doClick(continueBtn);
		
		if(eleUtil.WaitForElementVisible(succesfullMsg, Constants.DEFAULT_TIME_OUT).isDisplayed()) {
			
			eleUtil.doClick(logout);
			eleUtil.doClick(registerLink);
			
			
			return true;
		}
		
		return false;
		
	}

}



