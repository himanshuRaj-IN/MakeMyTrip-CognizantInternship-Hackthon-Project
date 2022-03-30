package testCases.VerifyRoomsAndAdultsFromHotelsPage;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;


public class GetListOfAdultOption extends BaseTestClass {

	LandingPage landingPage;
	CabsPage cabsPage;
	
	
	@Test
	public void listOfAdultOption() {
		logger = report.createTest("Print list of available adult option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();	
		hotelsPage.ClickOnRoomAndGuest();	
		hotelsPage.getListOfNumbersForAdultPerson();
	}
}
