package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Base {
	public static WebDriver driver;
	private static Supplier<WebDriverWait> getWait = () -> new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
	
	public static void openBrowser() {
		ConfigReader.loadProperty(Constants.CONFIG_FILEPATH);
		
		switch (ConfigReader.readProperty("browser")) {
			case "chrome" -> {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			case "firefox" -> {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			case "edge" -> {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			default -> System.out.println("NO SUCH BROWSER IN DIRECTORY");
		}
		driver.manage().deleteAllCookies();
		driver.get(ConfigReader.readProperty("url"));
		driver.manage().window().maximize();
		PageInitializer.initPages();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void click(WebElement element) {
		getWait.get().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	/**
	 * @param list         DataStructure that contains WebElements
	 * @param target       key to retrieve from list
	 * @param errorMessage if NoSuchElementException, custom message will be displayed
	 * @return WebElement target
	 */
	public static WebElement retrieveWebElementFromList(List<WebElement> list, String target, String errorMessage) {
		return list
				.stream()
				.filter(webelement -> webelement.getText().equals(target))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException(errorMessage));
	}
	
	/**
	 * @param webElement to check is displayed on webPage, (Assert.assertTrue)
	 * @return webElement
	 */
	public static boolean isElementDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static WebElement waitUntilElementBeVisible(WebElement element) {
		getWait.get().until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public static void sendText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("UNABLE TO SEND TEXT, NO SUCH WEB ELEMENT");
		} catch (StaleElementReferenceException s) {
			s.printStackTrace();
			System.out.println("Log.warning UNABLE TO SEND TEXT, STALE ELEMENT EXCEPTION");
		}
	}
	
	public static void selectValueFromDropDown(WebElement dropDown, String target) {
		try {
			new Select(dropDown).selectByVisibleText(target);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Log.warning NO SUCH DROPDOWN ELEMENT");
		} catch (StaleElementReferenceException s) {
			s.printStackTrace();
			System.out.println("Log.warning DROP DOWN STALE ELEMENT EXCEPTION");
		}
	}
	
	public static void isTextFieldEmpty(WebElement element) {
		try {
			assertTrue(element.getText().isEmpty());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Log.warning UNABLE TO CHECK IS FIELD EMPTY, NO SUCH ELEMENT");
		}
	}
	
	/**
	 * Method to check does error MSG NOT displayed on a page.
	 *
	 * @param list           contains webElements of error MSGs
	 * @param targetErrorMSG to be retrieved
	 */
	public static void identifyErrorMSG_And_IsNOT_Dispayed_TopOfCarbonHydrateCalculator(List<WebElement> list, String targetErrorMSG) {
		list
				.stream()
				.filter(s -> s.getText().equals(targetErrorMSG))
				.limit(1)
				.forEach(s -> assertFalse("Error message is present", isElementDisplayed(s)));
	}
	
	
	public static void identifyErrorMSG_And_Is_Dispayed_TopOfCarbonHydrateCalculator(List<WebElement> list, String targetErrorMSG) {
		list
				.stream()
				.filter(s -> s.getText().equals(targetErrorMSG))
				.limit(1)
				.forEach(s -> assertTrue("Error message is NOT present", isElementDisplayed(s)));
	}
	
	
}
