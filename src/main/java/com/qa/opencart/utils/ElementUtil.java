package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ElementUtil {
	
		private WebDriver driver;

		public ElementUtil(WebDriver driver) {

			this.driver = driver;
		}

		public WebElement getElement(By locator) {

			// driver.findElement(By.id("Form_getForm_Name"));

			return driver.findElement(locator);

		}

		public void doSendKeys(By locator, String value) {

			// driver.findElement(By.id("")).sendKeys("");
			getElement(locator).clear();
			getElement(locator).sendKeys(value);

		}

		public String doGetText(By locator) {

			// driver.findElement(By.linkText("")).getText();

			return getElement(locator).getText();

		}

		public Boolean doIsDisplayed(By locator) {

			return getElement(locator).isDisplayed();
		}

		public Boolean doIsEnabled(By locator) {

			return getElement(locator).isEnabled();
		}

		public Boolean doIsSelected(By locator) {

			return getElement(locator).isSelected();
		}

		public void doClick(By locator) {

			getElement(locator).click();

		}

		public void doSenKeys(String locatorType, String locatorValue, String value) {

			// driver.findElement(By.id("")).sendKeys(null);

			getElement(getBy(locatorType, locatorValue)).sendKeys(value);

		}

		public List<WebElement> getElements(By locator) {

			return driver.findElements(locator);
		}

		public List<String> getElementsTextList(By locator) {

			List<WebElement> eleList = getElements(locator);

			List<String> eleTextList = new ArrayList<String>();

			for (WebElement e : eleList) {

				String eleText = e.getText();

				if (!eleText.isEmpty()) {

					System.out.println(eleText);

					eleTextList.add(eleText);

				}
			}

			return eleTextList;

		}

		public List<String> getElementsAttributeList(By locator, String attributeName) {

			List<WebElement> eleList = getElements(locator);

			List<String> eleAttrList = new ArrayList<String>();

			for (WebElement e : eleList) {

				String atrributeValue = e.getAttribute(attributeName);

				System.out.println(atrributeValue);

				eleAttrList.add(atrributeValue);

			}

			return eleAttrList;

		}

		public int getElementcount(By locator) {

			return getElements(locator).size();

		}

		public By getBy(String locatorType, String locatorValue) {

			// By.id("");

			By locator = null;

			switch (locatorType.toLowerCase()) {

			case "id":
				locator = By.id(locatorValue);
				break;

			case "name":
				locator = By.name(locatorValue);
				break;

			case "classname":
				locator = By.className(locatorValue);
				break;
			case "xpath":
				locator = By.xpath(locatorValue);
				break;
			case "cssselector":
				locator = By.cssSelector(locatorValue);
				break;
			case "linktext":
				locator = By.linkText(locatorValue);
				break;
			case "partiallinktext":
				locator = By.partialLinkText(locatorValue);
				break;
			case "tagname":
				locator = By.tagName(locatorValue);
				break;

			default:
				break;
			}

			return locator;

		}

		// *********** Auto suggestion List Generic methods*******************//

		public void selectSuggestionLists(By searchlocator, By suggestionlocator, String searchValue, String suggValue)
				throws InterruptedException {

			driver.findElement(searchlocator).sendKeys(searchValue);

			Thread.sleep(3000);

			List<WebElement> suggestionlists = getElements(suggestionlocator);

			for (WebElement e : suggestionlists) {

				String text = e.getText();

				System.out.println(text);

				if (text.contains(suggValue)) {

					e.click();
					break;
				}

			}

		}

		public List<String> getSuggestionLists(By seachlocator, By suggestionlocator, String searchValue)
				throws InterruptedException {

			driver.findElement(seachlocator).sendKeys(searchValue);

			Thread.sleep(3000);

			List<WebElement> suggestionlists = getElements(suggestionlocator);
			List<String> suggestionListValue = new ArrayList<>();

			for (WebElement e : suggestionlists) {

				String text = e.getText();

				System.out.println(text);

				suggestionListValue.add(text);

			}

			return suggestionListValue;

		}

		//// ********DropDown Generic Methods**********************************///////

		public void selectDropDownByIndex(By locator, int index) {

			Select select = new Select(getElement(locator));

			select.selectByIndex(index);

		}

		public void selectDropdownByValue(By locator, String value) {

			Select select = new Select(getElement(locator));

			select.selectByValue(value);

		}

		public void selectDropDownByVisibleText(By locator, String text) {

			Select select = new Select(getElement(locator));

			select.selectByVisibleText(text);

		}

		public void deSelectDropDownByIndex(By locator, int index) {

			Select select = new Select(getElement(locator));

			select.selectByIndex(index);
			select.deselectByIndex(index);

		}

		public void deSelectDropDownByValue(By locator, String value) {

			Select select = new Select(getElement(locator));

			select.selectByValue(value);
			select.deselectByValue(value);

		}

		public void deSelectDropDownByVisibleText(By locator, String text) {

			Select select = new Select(getElement(locator));

			select.selectByVisibleText(text);
			select.deselectByVisibleText(text);

		}

		public void selectDropDownWithoutOptions(By locator, String value) {

			List<WebElement> getAllOptions = getElements(locator);

			for (WebElement e : getAllOptions) {

				String text = e.getText();

				if (text.contains(value)) {

					e.click();
					break;

				}

			}

		}

		public void selectDropDownFromOptions(By locator, String value) {

			Select sct = new Select(getElement(locator));

			List<WebElement> getAllOptions = sct.getOptions();

			for (WebElement e : getAllOptions) {

				String text = e.getText();

				if (text.contains(value)) {

					e.click();
					break;

				}

			}

		}

		public void selectMultipleDropDown(By locator, String... value) {

			Select select = new Select(getElement(locator));

			if (select.isMultiple()) {

				for (int i = 0; i < value.length; i++) {

					select.selectByVisibleText(value[i]);

				}

				List<WebElement> selectedOptions = select.getAllSelectedOptions();

				for (WebElement e : selectedOptions) {

					System.out.println(e.getText());

				}

			}

		}

		// ************ Actions class Generic Methods ****************//

		public void dragAndDropElementUsingBuildPerform(By source, By target) {

			Actions act = new Actions(driver);
			act.clickAndHold(getElement(source)).moveToElement(getElement(target)).build().perform();

		}

		public void dragAndDropElementUsingPerform(By source, By target) {

			Actions act = new Actions(driver);
			act.clickAndHold(getElement(source)).moveToElement(getElement(target)).perform();

		}

		public void dragAndDropElementUsingReleasePerform(By source, By target) {

			Actions act = new Actions(driver);
			act.clickAndHold(getElement(source)).moveToElement(getElement(target)).release().perform();

		}

		public void dragAndDropElementUsingReleaseBuildPerform(By source, By target) {

			Actions act = new Actions(driver);
			act.clickAndHold(getElement(source)).moveToElement(getElement(target)).release().build().perform();

		}

		// ************** Wait Generic Methods ********************//

		public WebElement WaitForElementPresence(By locator, int timeout) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		}

		public WebElement WaitForElementVisible(By locator, int timeout) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		}

		public String getTextFromAlert(int timeout) {

			return waitForAlert(timeout).getText();

		}

		public void acceptAlert(int timeout) {

			waitForAlert(timeout).accept();

		}

		public void dismissAlert(int timeout) {

			waitForAlert(timeout).dismiss();

		}

		public void senKeysAlert(int timeout, String value) {

			waitForAlert(timeout).sendKeys(value);

		}

		public Alert waitForAlert(int timeout) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			return wait.until(ExpectedConditions.alertIsPresent());

		}

		public String waitForTitleContains(int timeout, String title) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			if (wait.until(ExpectedConditions.titleContains(title))) {

				return driver.getTitle();

			}

			return null;

		}

		public String waitForTitleIs(int timeout, String title) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			if (wait.until(ExpectedConditions.titleIs(title))) {

				return driver.getTitle();

			}

			return null;

		}

		public String waitForUrlContains(int timeout, String url) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			if (wait.until(ExpectedConditions.urlContains(url))) {

				return driver.getCurrentUrl();

			}

			return null;

		}

		public String waitForUrlToBe(int timeout, String url) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			if (wait.until(ExpectedConditions.urlToBe(url))) {

				return driver.getCurrentUrl();

			}

			return null;

		}
		
		public void clickElementWhenReady(int timeout, By locator) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

		}
		

		public List<WebElement> waitForElementsVisible(int timeout, By locator) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		}

		public List<WebElement> waitForElementsPresences(int timeout, By locator) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		}
		

		public void  waitforElementToBeClickableWithPolling(By locator, int timeout, int pollingtime ) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingtime));
			
			
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			
		}

		
		}

		
	
