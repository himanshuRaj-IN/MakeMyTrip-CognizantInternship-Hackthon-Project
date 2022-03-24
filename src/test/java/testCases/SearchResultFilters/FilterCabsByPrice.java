package testCases.SearchResultFilters;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class FilterCabsByPrice extends BaseTestClass{
	
	@Test
	public void filterCabsByCabType() {
		logger = report.createTest("Filter Cabs By Price( Lowest to Highest) ");
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
		cabsPage.selectDepatureDate("24/05/2022");
		cabsPage.verifyDepatureDate("24/05/2022");
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("06:30 AM");
		cabsPage.verifyPickupTime("06:30 AM");		
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		searchPageCabs.filterBySuv();
		searchPageCabs.filterByPriceLH();
		searchPageCabs.verifyfiteredResult();
	}

}
