package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;

import java.util.NoSuchElementException;

import static steps.PageInitializer.fitnessAndHealthCalculators;
import static steps.PageInitializer.homePage;


public class NavigationHomePage extends Base {
	@When("user clicks on {string}")
	public void user_clicks_on(String calculatorCategory) {
		click(retrieveWebElementFromList(homePage.getListOfCalculatorCategories(),
				calculatorCategory,
				"NO SUCH CALCULATOR CATEGORY ON HOMEPAGE"));
	}
	
	
	@Then("user clicks on option {string}")
	public void userClicksOnOption(String calculatorType) {
		click(retrieveWebElementFromList(fitnessAndHealthCalculators.getListOfCalculators(),
				calculatorType,
				"NO SUCH CALCULATOR TYPE"));
	}
}
