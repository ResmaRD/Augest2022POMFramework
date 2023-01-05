package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searchResults = By.cssSelector("div.product-layout.product-grid");
	private By productNameLink;
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public int getSearchResultsCount() {
		
		return eleUtil.waitForElementsVisible(Constants.DEFAULT_TIME_OUT, searchResults).size();
	}
	
	public ProductInfoPage selectProduct(String productName) {

		productNameLink = By.linkText(productName);

		eleUtil.doClick(productNameLink);
		
		return new ProductInfoPage(driver);

	}

}
