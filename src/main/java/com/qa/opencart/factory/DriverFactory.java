package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager optionManager;
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		// mvn clean install -Denv="qa" -Dbrowser="chrome"

				// String browser = System.getProperty("browser");

			//	System.out.println("Browser passed from command line: " + browser);

		System.out.println("Browser name is : " + browserName);
		optionManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			//driver = new ChromeDriver();
		//	driver = new ChromeDriver(optionManager.getChromeOptions());
			threadLocal.set(new ChromeDriver(optionManager.getChromeOptions()));


		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

		//	driver = new FirefoxDriver();
			//driver = new FirefoxDriver(optionManager.getFirefoxOptions());
			threadLocal.set(new FirefoxDriver(optionManager.getFirefoxOptions()));


		}

		else if (browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}
		else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

		//	driver = new EdgeDriver();
			
			//driver = new EdgeDriver(optionManager.getEdgeOptions());
			threadLocal.set(new EdgeDriver(optionManager.getEdgeOptions()));

		}
		
		else {
			
			System.out.println("Please pass the right browser name : "+ browserName);
		}
		
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.get(prop.getProperty("url").trim());
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());

		
		return  getDriver();


	}
	

	public static WebDriver getDriver() {

		return threadLocal.get();
	}
	public Properties init_prop() {
		
		FileInputStream ip = null;
		prop = new Properties();

	
		// mvn clean install -Denv="prod"

				String envName = System.getProperty("env");

				if (envName == null) {

					System.out.println("No env is given ..Hence running it on QA environment");
					try {
						ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					} catch (FileNotFoundException e) {

						e.printStackTrace();
					}

				}

				else {
					
					try {

						switch (envName.toLowerCase()) {

						case "qa":
							System.out.println("Running it on QA env");
							ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
							break;
						case "dev":
							System.out.println("Running it on Dev env");
							ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
							break;
						case "stage":
							System.out.println("Running it on stage env");
							ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
							break;
						case "prod":
							System.out.println("Running it on prod env");
							ip = new FileInputStream("./src/test/resources/config/config.properties");
							break;

						default:

							System.out.println("Please pass the right env: " + envName);
							break;
						}
					}

					catch (Exception e) {

					}

				}
				try {

					prop.load(ip);
				} catch (IOException e) {

					e.printStackTrace();
				}


		return prop;

	}
	public String getScreenshot() {

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = "./" + "screenshot/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {

			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return path;

	}

}


