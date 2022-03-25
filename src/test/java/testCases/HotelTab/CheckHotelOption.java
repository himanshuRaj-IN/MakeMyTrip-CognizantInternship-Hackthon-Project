package testCases.HotelTab;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import pages.CabsPage;
import pages.HotelsPage;
import pages.LandingPage;
import pages.PagesBaseClass;

public class CheckHotelOption extends BaseTestClass {
	
	LandingPage landingPage;
	CabsPage cabsPage;
	HotelsPage hotelsPage;
	
	
	@Test
	public void checkHotelOption() {
		logger = report.createTest("Check Hotel Option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.CheckHotelMenuOption();	
	}

}
