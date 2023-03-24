package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Base;

public class Hooks {
	
	@Before
	public static void beforeTest(){
		Base.openBrowser();
	}
	
	@After
	public void afterTest(){
		Base.quitBrowser();
	}
}
