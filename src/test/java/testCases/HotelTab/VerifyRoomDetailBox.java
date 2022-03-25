package testCases.HotelTab;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import pages.CabsPage;
import pages.LandingPage;
import pages.PagesBaseClass;

public class VerifyRoomDetailBox extends BaseTestClass {

	LandingPage landingPage;
	CabsPage cabsPage;
	
	
	@Test
	public void checkRoomDetailBox() {
		logger = report.createTest("Verify Room and Guest box ");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();	
		hotelsPage.ClickOnRoomAndGuest();	
		hotelsPage.verifyRoomDetailsPopUp();
	}
}
