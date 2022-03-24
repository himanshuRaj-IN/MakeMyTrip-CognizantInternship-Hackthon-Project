package testCases.FillingCabsDetails;


import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class CitySelection_FROMTest extends BaseTestClass {
		
	@Test
	public void citySelection_FROM() {
		logger = report.createTest("FROM City Selection");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.enterFROMCity("Delhi");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Delhi, India");
		cabsPage.verifyFROMSelectedCity("Delhi, India");
	}
	
}
