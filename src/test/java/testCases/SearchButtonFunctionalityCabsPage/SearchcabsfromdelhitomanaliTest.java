package testCases.SearchButtonFunctionalityCabsPage;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SearchcabsfromdelhitomanaliTest extends BaseTestClass{
	
	
	@Test
	public void searchcabsfromdelhitomanali() {
		logger = report.createTest("Search Cabs from Delhi to Manali ");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.enterFROMCity("Delhi");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Delhi, India");
		cabsPage.verifyFROMSelectedCity("Delhi, India");
		cabsPage.enterTOCity("Manali");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Manali, Himachal Pradesh, India");
		cabsPage.verifyTOSelectedCity("Manali, Himacha...");
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("02/04/2022");
		cabsPage.verifyDepatureDate("02/04/2022");
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("01:40 AM");
		cabsPage.verifyPickupTime("01:40 AM");		
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
