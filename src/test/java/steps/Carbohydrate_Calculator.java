package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Base;

import static steps.PageInitializer.carbohydrateCalculator;


public class Carbohydrate_Calculator extends Base {
	@When("user clicks on button {string}")
	public void user_clicks_on_button(String button) {
		click(retrieveWebElementFromList(carbohydrateCalculator.getCategoryRelated(),
				button,
				"no such element"));
	}
	
	@Then("verify title {string}")
	public void verify_title(String title) {
		Assert.assertEquals(getTitle(), title);
	}
	
	@When("user clicks on dashboard tab {string}")
	public void user_clicks_on_dashboard_tab(String tab) {
		click(waitUntilElementBeVisible(
				retrieveWebElementFromList(
						carbohydrateCalculator.getDashboardTabs(),
				tab, "no such dashboard tab in Carbohydrate Calculator")));
	}
	
	
	@Then("verify tab title {string}")
	public void verify_tab_title(String title) {
		Assert.assertEquals(getTitle(), title);
	}
	
	
}
