package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Base.driver;

@Getter
public class HomePage {
	@FindBy(xpath = "//div[@class='homelisttile']/div[2]/a")
	private List<WebElement> listOfCalculatorCategories;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
}
