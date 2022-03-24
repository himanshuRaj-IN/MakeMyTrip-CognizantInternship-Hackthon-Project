package testCases.GiftCardPageSelection;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.GiftCardsPage;

public class NavigateGiftCardsPageTest extends BaseTestClass{
	
	@Test
	public void navigateGiftCardsPageTest() {
		logger = report.createTest("Navigate Gift Cards Page");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		driver.close();
		driver.switchTo().window(currWin);

		
		
		
		
	}

}
