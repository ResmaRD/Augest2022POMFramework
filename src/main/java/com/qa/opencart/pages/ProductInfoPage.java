package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productHeader = By.cssSelector("div#content h1");
	private By productDetails = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	//private By productDetails1=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By addToCart = By.cssSelector("button#button-cart");
	private By successfullAddMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
	

	public ProductInfoPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public String getProductHeaderName() {
		
		return eleUtil.WaitForElementVisible(productHeader, Constants.DEFAULT_TIME_OUT).getText();
	}
	
	public Map<String, String> getProductDetails() {
		
//	List<WebElement>productDetailsLists = eleUtil.waitForElementsVisible(Constants.DEFAULT_TIME_OUT, productDetails);
	
	List<String>	productDetailsLists= eleUtil.getElementsTextList(productDetails);
	
//	Brand: Apple
//	Product Code: Product 14
//	Availability: In Stock
//	$122.00
//	Ex Tax: $100.00
		
	Map<String, String> map = new HashMap<String, String>();
	
	for(String list : productDetailsLists) {
		
		String name[]= list.split(":");
		
		//map.put(name[0].trim(),name[1].trim());
		
	        String key = name[0].trim();
			String value = name[1].trim();

			map.put(key, value);

		}

		return map;
	}

	public String getProductInfoPageText() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String pagetext = js.executeScript("return document.documentElement.innerText").toString();

		System.out.println("------------------------\n" + pagetext + "-------------------------\n");

		return pagetext;
	}

	public void doClickAddToCart() {

		eleUtil.WaitForElementVisible(addToCart, Constants.DEFAULT_TIME_OUT).click();
	}

	public void getSuccuesfullMessage() {

	String text = 	eleUtil.WaitForElementVisible(successfullAddMessage, Constants.DEFAULT_TIME_OUT).getText();
	System.out.println(text);

		
	}
}




