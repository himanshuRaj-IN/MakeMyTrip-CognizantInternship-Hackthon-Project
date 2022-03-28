package testCases.SearchButtonFunctionalityCabsPage;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class CheckSearchButtonTest extends BaseTestClass{
	@Test
	public void checkSearchButton() {
		logger = report.createTest("Check Search button available and enabled.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.verifySearchButtonAvailable();
	}

}
