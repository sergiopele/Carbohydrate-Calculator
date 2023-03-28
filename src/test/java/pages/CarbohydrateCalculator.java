package pages;


import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Base.click;
import static utils.Base.driver;

@Getter
public class CarbohydrateCalculator {
	
	@FindBy(xpath = "//input[@name='cheightmeter']")
	private WebElement heightMetricUnit;
	@FindBy(xpath = "//input[@name='ckg']")
	private WebElement weightMetricUnit;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement age;
	@FindBy(xpath = "//select[@id='cactivity']")
	private WebElement activityDropDown;
	@FindBy(xpath = "//div[@id='topmenu']/ul/li/a")
	private List<WebElement> unitType;
	@FindBy(xpath = "//input[@value='Calculate']")
	private WebElement calculateButton;
	@FindBy(xpath = "//div[@class='topNavAbs']/a")
	private List<WebElement> dashboardTabs;
	@FindBy(xpath = "//fieldset/a")
	private List<WebElement>categoryRelated;
	@FindBy(xpath = "//div[@id='topmenu']/ul/li/a")
	private List<WebElement>unitOption;
	@FindBy(xpath = "//td/label/span[@class='rbmark']")
	private List<WebElement>gender;
	@FindBy(id = "cheightfeet")
	private WebElement feetUsUnit;
	@FindBy(id = "cheightinch")
	private WebElement inchesUsUnit;
	@FindBy(id = "cpound")
	private WebElement poundsUsUnit;
	@FindBy(xpath = "//a[text()='+ Settings']")
	private WebElement settingButton;
	@FindBy(xpath = "//div[@id='ccsettingcontent']/div[2]/div/label/span")
	private List<WebElement>bmr_estimation_farmula;
	@FindBy(xpath = "//img[@class='clearbtn']")
	private WebElement clearButton;
	@FindBy(xpath = "//input[@name='cfatpct']")
	private WebElement bodyFatField;
	@FindBy(xpath = "//font[@color='red']")
	private List<WebElement> errorMessageTopOfCalculator;

	
	public CarbohydrateCalculator() {
		PageFactory.initElements(driver, this);
	}
	
	
	
}
