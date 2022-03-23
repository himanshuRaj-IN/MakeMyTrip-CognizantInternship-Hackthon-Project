package testCases.CabsPageSelectionFromMenu;

import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import pages.CabsPage;
import pages.LandingPage;
import pages.PagesBaseClass;


public class CheckCabsOption extends BaseTestClass{
	
	LandingPage landingPage;
	CabsPage cabsPage;
	
	
	@Test
	public void checkCabsOption() {
		logger = report.createTest("Check Cabs Option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		landingPage.checkCabsOption();	
	}
	

	

	

}
