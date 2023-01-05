package com.qa.opencart.factory;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class OptionsManager {
	private Properties prop;
	private ChromeOptions chromeOption;
	private FirefoxOptions firefoxOption;
	private EdgeOptions edgeOption;

	public OptionsManager(Properties prop) {

		this.prop = prop;

	}

	public ChromeOptions getChromeOptions() {

		chromeOption = new ChromeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless"))) {

			chromeOption.setHeadless(true);

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {

			chromeOption.addArguments("--incognito");

		}

		return chromeOption;

	}

	public FirefoxOptions getFirefoxOptions() {

		firefoxOption = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless"))) {

			firefoxOption.setHeadless(true);

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {

			firefoxOption.addArguments("--incognito");

		}

		return firefoxOption;

	}

	public EdgeOptions getEdgeOptions() {

		edgeOption = new EdgeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless"))) {

			edgeOption.setHeadless(true);
		}

		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {

			edgeOption.addArguments("--incognito");

		}

		return edgeOption;

	}

}




