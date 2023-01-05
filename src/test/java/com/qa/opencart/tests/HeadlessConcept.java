package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HeadlessConcept {

	//Headless ->Browser will not launch
	//testing is happening behind the scene
	//faster than the normal mode
	//its will block the visual service of browser
	
	//incognito mode /private m,ode
	
	// no history for the browser

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co = new ChromeOptions();
		
	//	co.addArguments("--headless");
		
	//	co.setHeadless(true);
		
		
	//	co.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.amazon.in/");
		
		System.out.println("title is : "+ driver.getTitle());
		System.out.println("current url is : "+ driver.getCurrentUrl());
		
		driver.quit();
		

	}

}



