package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class NewAccountPage {
	private By accountHeader = By.xpath("//div[@id='content']//child::h2[text()='My Account']");
	private By logout = By.linkText("Logout");
	private By search = By.cssSelector("input[name ='search']");
	private By sectionHeaders = By.cssSelector("div#content h2");
	private By searchIcon = By.cssSelector("div#search button");

}
