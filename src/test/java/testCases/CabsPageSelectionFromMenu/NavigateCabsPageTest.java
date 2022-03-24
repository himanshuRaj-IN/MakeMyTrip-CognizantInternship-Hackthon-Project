package testCases.CabsPageSelectionFromMenu;


import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;


public class NavigateCabsPageTest extends BaseTestClass {

	LandingPage landingPage;
	CabsPage cabsPage;
	
	@Test
	public void navigateCabsPageTest() {
		logger = report.createTest("Navigate Cab Page");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.verifyCabsPageURL();
		cabsPage.verifySubHeading();
		cabsPage.verifyCabsPageURL();
	}
	

	

}
