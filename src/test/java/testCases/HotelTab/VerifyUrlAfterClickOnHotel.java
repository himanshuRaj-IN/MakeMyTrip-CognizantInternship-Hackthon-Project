package testCases.HotelTab;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.HotelsPage;
import pages.LandingPage;


public class VerifyUrlAfterClickOnHotel extends BaseTestClass{
	LandingPage landingPage;
	CabsPage cabsPage;
	HotelsPage hotelsPage;
	
	
	@Test
	public void verifyUrlOfHotel() {
		logger = report.createTest("Verify Url of  Hotel Option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();	
		hotelsPage.verifyHotelsPageURL();
	}
}
