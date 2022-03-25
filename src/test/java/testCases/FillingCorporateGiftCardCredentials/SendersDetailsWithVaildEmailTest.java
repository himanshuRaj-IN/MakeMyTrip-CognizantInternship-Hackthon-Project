package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithVaildEmailTest extends BaseTestClass {

	@Test
	public void sendersDetailsWithValidEmail() throws InterruptedException {
		logger = report.createTest("Senders Details With Valid Email");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName();
		giftCardsPage.enterMobileNo();
		giftCardsPage.enterValidEmailId();
		giftCardsPage.clickonBuyNowButton();
		boolean flag = giftCardsPage.isRedirectedToPaymentPage();
		Assert.assertEquals(flag, true);
		driver.close();
		driver.switchTo().window(currWin);
	}

}
