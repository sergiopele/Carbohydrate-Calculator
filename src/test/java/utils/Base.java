package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

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
		return list.stream()
				.filter(webelement -> webelement.getText().equals(target))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException(errorMessage));
	}
	
	/**
	 * @param webElement to check is displayed on webPage, (Assert.assertTrue)
	 * @return webElement
	 */
	public static WebElement isElementDisplayed(WebElement webElement) {
		Assert.assertTrue(webElement.isDisplayed());
		return webElement;
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static WebElement waitUntilElementBeVisible(WebElement element) {
		getWait.get().until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public static void sendText(WebElement element, String text){
		element.sendKeys(text);
	}
	
	
}
