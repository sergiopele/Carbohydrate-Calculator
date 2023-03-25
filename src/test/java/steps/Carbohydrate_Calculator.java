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
	
	
	@When("user enters {string} in Age")
	public void user_enters_in_age(String age) {
		sendText(carbohydrateCalculator.getAge(), age);
	}
	
	@When("user clicks on {string} gender")
	public void user_clicks_on_gender(String gender) {
		switch (gender) {
			case "Male" -> click(carbohydrateCalculator.getGender().get(0));
			case "Female" -> click(carbohydrateCalculator.getGender().get(1));
			default -> throw new RuntimeException("NO SUCH GENDER");
		}
	}
	
	@When("user enters {string} into feets")
	public void user_enters_into_feets(String feets) {
		sendText(carbohydrateCalculator.getFeetUsUnit(), feets);
	}
	
	@When("user enters {string} into inches")
	public void user_enters_into_inches(String inches) {
		sendText(carbohydrateCalculator.getInchesUsUnit(), inches);
	}
	
	@When("user enters {string} into pounds")
	public void user_enters_into_pounds(String pounds) {
		sendText(carbohydrateCalculator.getPoundsUsUnit(), pounds);
	}
	
	@When("user selects {string}")
	public void user_selects(String activity) {
		selectValueFromDropDown(carbohydrateCalculator.getActivityDropDown(), activity);
	}
	
	@When("user clicks on Settings")
	public void user_clicks_on_settings() {
		click(carbohydrateCalculator.getSettingButton());
	}
	
	@When("user clicks on {string} option")
	public void user_clicks_on_option(String bmr_estimation_formula)  {
		switch (bmr_estimation_formula) {
			case "Mifflin St Jeor" -> click(carbohydrateCalculator.getBmr_estimation_farmula().get(0));
			case "Katch-McArdle" -> click(carbohydrateCalculator.getBmr_estimation_farmula().get(1));
			default -> throw new RuntimeException("NO SUCH BMR ESTIMATION FORMULA OR TARGET KEY IS WRONG");
		}
	}
	
	@When("user clicks on Clear button")
	public void user_clicks_on_clear_button() {
		click(carbohydrateCalculator.getClearButton());
	}
	
	@Then("all entered fields age, feets, inches, pounds should be empty")
	public void all_entered_fields_age_feets_inches_pounds_should_be_empty() {
		isTextFieldEmpty(carbohydrateCalculator.getAge());
		isTextFieldEmpty(carbohydrateCalculator.getInchesUsUnit());
		isTextFieldEmpty(carbohydrateCalculator.getFeetUsUnit());
		isTextFieldEmpty(carbohydrateCalculator.getPoundsUsUnit());
		isTextFieldEmpty(carbohydrateCalculator.getBodyFatField());
	}
	
	
}
