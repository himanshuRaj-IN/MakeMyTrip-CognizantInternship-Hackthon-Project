package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithoutNameTest extends BaseTestClass {
	@Test
	public void sendersDetailsWithoutName() throws InterruptedException {
		logger = report.createTest("Senders Details Without Name");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("");
		giftCardsPage.enterMobileNo("7002041998");
		giftCardsPage.enterValidEmailId("singhpushkar108@gmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage. CredentialsWithoutNameErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		driver.close();
		driver.switchTo().window(currWin);
	}
}
