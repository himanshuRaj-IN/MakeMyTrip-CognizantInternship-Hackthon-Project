package testCases.FillingCabsDetails;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class PickupTimeSelection extends BaseTestClass {
	
	@Test
	public void pickupTimeSelection() {
		logger = report.createTest("Select Pickup-Time");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("01:40 AM");
		cabsPage.verifyPickupTime("01:40 AM");
		
		try {
			Thread.sleep(5200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
