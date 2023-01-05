package com.qa.opencart.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;


public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By accountHeader = By.xpath("//div[@id='content']//child::h2[text()='My Account']");
	private By logout = By.linkText("Logout");
	private By search = By.cssSelector("input[name ='search']");
	private By sectionHeaders = By.cssSelector("div#content h2");
	private By searchIcon = By.cssSelector("div#search button");
	public AccountsPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountpageTitle() {

		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}

	public String getAccountpageUrl() {

		return eleUtil.waitForUrlContains(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_URL_FRACTION);
	}

	public boolean isAccountHeaderExist() {

		return eleUtil.WaitForElementVisible(accountHeader, Constants.DEFAULT_TIME_OUT).isDisplayed();

	}
	public String getAccountHeaderText() {

		if (isAccountHeaderExist()) {

			return eleUtil.WaitForElementVisible(accountHeader, Constants.DEFAULT_TIME_OUT).getText();

		}

		return null;

	}

	
	public List<String> getAccountPageSectionsList() {

		return eleUtil.getElementsTextList(sectionHeaders);

	}

	public boolean isLogoutLinkExist() {

		return eleUtil.WaitForElementVisible(logout, Constants.DEFAULT_TIME_OUT).isDisplayed();

	}

	public LoginPage clickOnLogOut() {

		if (isLogoutLinkExist()) {

			eleUtil.doClick(logout);
			
			return new LoginPage(driver);

		}
		return null;

	}
	
	public boolean isSearchFieldExist() {

		return eleUtil.WaitForElementVisible(search, Constants.DEFAULT_TIME_OUT).isDisplayed();

	}

	public SearchResultsPage doSearch(String searchKey) {

		if (isSearchFieldExist()) {

			eleUtil.doSendKeys(search, searchKey);

			eleUtil.doClick(searchIcon);

			return new SearchResultsPage(driver);
		}

		return null;
	}


	

}
