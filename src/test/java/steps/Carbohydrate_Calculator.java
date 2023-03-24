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
				"no such button in Related section"));
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
	
	@When("user click on {string} option")
	public void user_click_on_option(String unitOption) {
		click(retrieveWebElementFromList(carbohydrateCalculator.getUnitOption(),
				unitOption,
				"no such unit option in Carbonhydrate Calculator"));
	}
	
	
	@When("user enters {int} in Age")
	public void user_enters_in_age(Integer age) {
		sendText(carbohydrateCalculator.getAge(), String.valueOf(age));
	}
	@When("user clicks on {string} gender")
	public void user_clicks_on_gender(String gender) {
	
	}
	@When("user enters {int} into feets")
	public void user_enters_into_feets(Integer int1) {
	
	}
	@When("user enters {int} into inches")
	public void user_enters_into_inches(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("user enters {int} into pounds")
	public void user_enters_into_pounds(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("user selects {string}")
	public void user_selects(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on Settings")
	public void user_clicks_on_settings() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on {string} option")
	public void user_clicks_on_option(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on Clear button")
	public void user_clicks_on_clear_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Then("all entered fields age, feets, inches, pounds should be empty")
	public void all_entered_fields_age_feets_inches_pounds_should_be_empty() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
	
}
