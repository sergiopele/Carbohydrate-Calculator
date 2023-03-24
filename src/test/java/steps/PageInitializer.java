package steps;

import pages.CarbohydrateCalculator;
import pages.FitnessAndHealthCalculators;
import pages.HomePage;

public class PageInitializer {
	public static HomePage homePage;
	public static FitnessAndHealthCalculators fitnessAndHealthCalculators;
	public static CarbohydrateCalculator carbohydrateCalculator;
	
	
	public static void initPages() {
		homePage = new HomePage();
		fitnessAndHealthCalculators = new FitnessAndHealthCalculators();
		carbohydrateCalculator = new CarbohydrateCalculator();
		
	}
}
