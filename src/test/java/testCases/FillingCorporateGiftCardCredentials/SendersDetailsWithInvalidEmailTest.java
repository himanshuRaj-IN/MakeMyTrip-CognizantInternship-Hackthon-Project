package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithInvalidEmailTest  extends BaseTestClass {
	
	
	@Test
	public void sendersDetailsWithInValidEmail() throws InterruptedException {
		logger = report.createTest("Senders Details With InValid Email");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterMobileNo("7002041998");
		giftCardsPage.enterValidEmailId("xyzgmail.com");
		
		giftCardsPage.clickonBuyNowButton();
		boolean flag = giftCardsPage.displayingErrorMessage();
		Assert.assertEquals(flag, true);
		driver.close();
		driver.switchTo().window(currWin);
	}
}
