package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Base.driver;

@Getter
public class FitnessAndHealthCalculators {
	@FindBy(xpath = "//td[@class='sectionlists']/div/a")
	private List<WebElement> listOfCalculators;
	
	public FitnessAndHealthCalculators() {
		PageFactory.initElements(driver, this);
	}
}
